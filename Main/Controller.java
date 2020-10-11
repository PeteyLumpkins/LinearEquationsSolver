package Main;

import Commands.*;

public class Controller {

    private Command command;

    public Controller() {

    }

    public Controller(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    public void setCommand(Command newCmd) {
        this.command = newCmd;
    }
}
