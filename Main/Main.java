package Main;

import Commands.*;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Input input = new Input();

        controller.setCommand(new GetConsoleInput(input));
        controller.execute();

        controller.setCommand(new BuildLinearSystem(input));
        controller.execute();

        controller.setCommand(new SolveSystem(input.getSystem()));
        controller.execute();

        controller.setCommand(new PrintSystemSolutions(input.getSystem()));
        controller.execute();
    }
}
