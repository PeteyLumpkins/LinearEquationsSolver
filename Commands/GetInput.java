package Commands;

import Main.Input;

public class GetInput implements Command{

    private Input input;

    public GetInput(Input input) {
        this.input = input;
    }

    @Override
    public void execute() {
        input.getFileInput();
    }
}
