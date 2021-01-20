package Commands;

import Main.Input;

public class BuildLinearSystem implements Command{

    private Input input;

    public BuildLinearSystem(Input input) {
        this.input = input;
    }

    @Override
    public void execute() {
        input.processData();
    }

}
