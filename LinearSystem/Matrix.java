package LinearSystem;

public class Matrix {
    private final double EPSILON = .00000000001;
    private int rows;
    private int cols;
    private double[][] table;
    private final double[][] UPPER_TRIANGULAR_FORM;
    private final double[][] ORIGINAL_MATRIX;

    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.cols = findMaxRowLength(matrix);
        this.table = createMatrix(matrix);
        this.ORIGINAL_MATRIX = createMatrix(matrix);
        convertToUpperTriangularForm();
        this.UPPER_TRIANGULAR_FORM = createMatrix(table);
    }

    public int rows() {
        return this.rows;
    }
    public int cols() {
        return this.cols;
    }
    public double[][] originalMatrix() {
        return this.ORIGINAL_MATRIX;
    }
    public double[][] upperTriangularForm() {
        return this.UPPER_TRIANGULAR_FORM;
    }

    private void convertToUpperTriangularForm() {
        double num, factor = 0, pivot;
        for (int i = 0; rows >= cols ? i < cols : i < rows; i++) {
            pivot = findPivot(i, i);
            for (int j = i + 1; j < rows; j++) {
                num = table[j][i];
                factor = (-num / pivot);
                for (int k = 0; k < this.table[i].length; k++) {
                    table[j][k] += table[i][k] * factor;

                    if (Math.abs(table[j][k]) < EPSILON) {
                        table[j][k] = 0;
                    }
                }
            }
        }
    }

    private double findPivot(int row, int col) {
        double pivot = table[col][col];
        if (Math.abs(pivot) < EPSILON) {
            for (int j = row + 1; j < rows; j++) {
                if (Math.abs(table[j][col]) >= EPSILON) {
                    swapRows(row, j);
                    break;
                }
            }
            pivot = table[col][col];
        }

        return pivot;
    }

    private void swapRows(int row1, int row2) {
        double[] temp = new double[table[row1].length];
        System.arraycopy(table[row1], 0, temp, 0, temp.length);
        System.arraycopy(table[row2], 0, table[row1], 0, table[row1].length);
        System.arraycopy(temp, 0, table[row2], 0, table[row2].length);
    }

    private double[][] createMatrix(double[][] matrix) {
        double[][] temp = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        return temp;
    }

    private int findMaxRowLength(double[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > max) {
                max = matrix[i].length;
            }
        }
        return max;
    }


}
