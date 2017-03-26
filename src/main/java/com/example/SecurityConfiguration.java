package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
  @Autowired
  public void configureAuth(AuthenticationManagerBuilder builder) throws Exception
  {
    builder
      .inMemoryAuthentication()
      .withUser("marcel").password("1234").roles("USER")
      .and()
      .withUser("admin").password("admin").roles("USER", "ADMIN", "ACTUATOR");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/customers").permitAll()
      .anyRequest().authenticated().and().httpBasic();
  }
}
