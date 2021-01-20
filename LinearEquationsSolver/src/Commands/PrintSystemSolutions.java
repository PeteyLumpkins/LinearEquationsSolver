package Commands;

import LinearSystem.LinearSystem;

public class PrintSystemSolutions implements Command {

    private LinearSystem system;

    public PrintSystemSolutions(LinearSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {

        System.out.println(system.solutions());

    }
}
