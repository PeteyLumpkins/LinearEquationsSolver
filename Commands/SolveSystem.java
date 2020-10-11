package Commands;

import LinearSystem.LinearSystem;

public class SolveSystem implements Command{

    private LinearSystem system;

    public SolveSystem(LinearSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        system.solve();
    }
}
