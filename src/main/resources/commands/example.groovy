package commands

import org.crsh.cli.Command
import org.crsh.cli.Man
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@Usage("Example commands")
class example {

  @Usage("Test custom command")
  @Man("use to test custom command")
  @Command
  def test(InvocationContext context) {
    "Hello World"
  }
}
