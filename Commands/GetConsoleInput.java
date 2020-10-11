package Commands;
import Main.*;

public class GetConsoleInput implements Command {

    private Input input;

    public GetConsoleInput(Input input) {
        this.input = input;
    }

    public void execute() {
        input.getConsoleInput();
    }
}
