package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import LinearSystem.*;


public class Input {

    private String[] input;
    private int size;
    private double[][] data;
    private LinearSystem system;

    private String outputFileName = "out.txt";
    private String inputFileName = "in.txt";

    public Input(String[] input) {
        this.input = input;
        this.size = input.length;
        processArgs();
    }

    public Input() {
    }

    public Input(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public String getOutputFileName() {
        return this.outputFileName;
    }

    public String getInputFileName() {
        return this.inputFileName;
    }

    public LinearSystem getSystem() {
        return this.system;
    }

    private void processArgs() {
        final String INPUT_MARKER = "-in";
        final String OUTPUT_MARKER = "-out";

        for (int i = 0; i < size; i+=2) {

            if (input[i].equals(INPUT_MARKER)) {
                inputFileName = input[i + 1];
            }

            if(input[i].equals(OUTPUT_MARKER)) {
                outputFileName = input[i + 1];
            }
        }
    }

    public void getFileInput() {
        try (Scanner scan = new Scanner(new File(inputFileName))) {
            int c = scan.nextInt() + 1;
            int r = scan.nextInt();
            data = new double[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    data[i][j] = scan.nextDouble();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public void getConsoleInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of variables: ");
        int variables = scan.nextInt() + 1;
        System.out.print("Enter number of equations: ");
        int equations = scan.nextInt();
        data = new double[equations][variables];
        for (int i = 0; i < equations; i++) {
            System.out.print("Enter row " + i + ": ");
            for (int j = 0; j < variables; j++) {
                data[i][j] = scan.nextDouble();
            }
        }
    }

    public void processData() {
        this.system = new LinearSystem(this.data);
    }
}
