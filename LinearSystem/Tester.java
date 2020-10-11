package LinearSystem;
import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        double[][] d = new double[][]{ {0, 5, 2, 3} , {3, 4, 0, 4} , {2, 4, 2, 1} };

        double[][] m = new Matrix(d).upperTriangularForm();
        for (double[] dub : m) {
            System.out.println(Arrays.toString(dub));
        }
    }
}
