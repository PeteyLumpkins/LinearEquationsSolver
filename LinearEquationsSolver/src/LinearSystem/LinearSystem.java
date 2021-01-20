package LinearSystem;

import java.util.NoSuchElementException;

public class LinearSystem {
    private static final double EPSILON = .00000000001;
    private int rows;
    private int cols;
    private int significantEquations;
    private int significantVariables;

    private Variable[] variables;
    private LinearEquation[] equations;
    private Matrix matrix;

    private boolean noSolutions = false;
    private boolean infiniteSolutions = false;

    public LinearSystem(Matrix matrix) {
        this.rows = matrix.rows();
        this.cols = matrix.cols();
        this.matrix = matrix;

        createVariables(cols - 1);
        createEquations(rows);

        significantEquations = significantEquations();
        significantVariables = cols - 1;
        if (significantEquations > significantVariables) {
            noSolutions = true;
        }
        if (significantVariables > significantEquations) {
            infiniteSolutions = true;
        }

        hasNoSolutions();
    }

    public LinearSystem(double[][] matrix) {
        this(new Matrix(matrix));
    }

    public void solve() {
        for (int i = rows - 1; i >= 0; i--) {
            equations[i].solve();
        }
    }

    public String solutions() {
        StringBuilder result = new StringBuilder();
        if (hasNoSolution()) {
            result.append("No solutions");
        } else if (hasInfiniteSolution()) {
            result.append("Infinitely many solutions");
        } else {
            for (int i = 0; i < cols - 1; i++) {
                result.append(variables[i].symbol);
                result.append(variables[i].varNum);
                result.append(" = ");
                result.append(variables[i].value);
                result.append("\n");
            }
        }
        return result.toString();
    }

    public boolean hasNoSolution() {
        return noSolutions;
    }

    public boolean hasInfiniteSolution() {
        return infiniteSolutions;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            result.append(equations[i].toString());
            result.append("\n");
        }
        return result.toString();
    }

    private void hasNoSolutions() {
        for (LinearEquation eq : equations) {
            if (eq.isInvalid()) {
                noSolutions = true;
                break;
            }
        }
    }

    private int significantEquations() {
        int total = 0;
        for (LinearEquation eq : equations) {
            if (!eq.isInsignificant()) {
                total++;
            }
        }
        return total;
    }

    private void createEquations(int numEquations) {
        equations = new LinearEquation[numEquations];
        for (int i = 0; i < rows; i++) {
            equations[i] = new LinearEquation(matrix.upperTriangularForm()[i], variables);
        }

    }

    private void createVariables(int numVars) {
        variables = new Variable[numVars];
        for (int i = 0; i < numVars; i++) {
            variables[i] = new Variable();
        }
    }

    private static class Variable {
        private static int numVars;
        private double value;
        private String symbol;
        private int varNum;
        private boolean hasVal;


        public Variable() {
            this("X", numVars + 1);
        }

        public Variable(double value) {
            this();
            setValue(value);
        }

        public Variable(String symbol, int varNum) {
            this.symbol = symbol;
            this.varNum = varNum;
            numVars++;
        }

        @Override
        public String toString() {
            return symbol + varNum;
        }

        public void setValue(double value) {
            this.value = value;
            this.hasVal = true;
        }

        public boolean hasValue() {
            return hasVal;
        }
    }

    private static class Number {
        private Variable var;
        private double coefficient;
        private double value;
        private boolean hasVal;

        public Number(double coefficient) {
            this(coefficient, new Variable(1));
        }

        public Number(double coefficient, Variable var) {
            this.var = var;
            this.coefficient = coefficient;
            update();
        }

        public double value() {
            if (!hasValue()) {
                throw new NoSuchElementException();
            }
            return this.value;
        }

        public Variable variable() {
            return this.var;
        }

        public boolean hasValue() {
            return hasVal || update();
        }

        public double coefficient() {
            return this.coefficient;
        }

        @Override
        public String toString() {
            return "" + this.coefficient + this.var.toString();
        }

        private boolean update() {
            if (this.coefficient == 0) {
                this.value = 0;
                return true;
            }

            if (this.var.hasValue()) {
                this.value = coefficient * var.value;
                return true;
            }
            return false;
        }
    }

    private static class LinearEquation {
        private Number[] numbers;
        private Number sum;
        private int size;

        private boolean insignificant = false;
        private boolean invalid = false;

        public LinearEquation(double[] coefficients, Variable[] variables) {
            this.size = coefficients.length;
            numbers = new Number[size - 1];
            this.sum = new Number(coefficients[size - 1]);
            for (int i = 0; i < size - 1; i++) {
                numbers[i] = new Number(coefficients[i], variables[i]);
            }
            update();
        }

        public boolean isSolvable() {

            return unknownVars() == 1 && !invalid;
        }

        public boolean isInsignificant() {
            return insignificant;
        }

        public boolean isInvalid() {
            return invalid;
        }

        public void solve() {
            if (isSolvable()) {
                setUnknownVarValue();
            }
        }

        private void update() {

            int numZeros = countZeros();

            if (numZeros == size) {
                insignificant = true;
            } else if (numZeros == (size - 1) && Math.abs(this.sum.coefficient()) >= EPSILON) {
                invalid = true;
            }
        }

        private int countZeros() {
            int total = 0;
            for (Number num : numbers) {
                if (Math.abs(num.coefficient()) < EPSILON) {
                    total++;
                }
            }
            if (Math.abs(sum.coefficient()) < EPSILON) {
                total++;
            }
            return total;
        }

        private void setUnknownVarValue() {
            double sum = this.sum.value();
            Number temp = null;
            for (Number num : numbers) {
                if (!num.hasValue()) {
                    temp = num;
                } else {
                    sum -= num.value();
                }
            }

            if (temp != null) {
                sum /= temp.coefficient();
                temp.variable().setValue(sum);
            }
        }

        private int unknownVars() {
            int unknownVars = 0;
            for (Number num : numbers) {
                if (!num.hasValue()) {
                    unknownVars++;
                }
            }
            return unknownVars;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(numbers[0]);
            for (int i = 1; i < size - 1; i++) {
                result.append(" + ");
                result.append(numbers[i].toString());
            }
            result.append(" = ");
            result.append(sum);
            return result.toString();
        }
    }
}
