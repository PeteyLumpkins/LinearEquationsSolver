package Commands;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SendToFile implements Command {

    private String data;
    private String fileName;

    public SendToFile(String data, String fileName) {
        this.data = data;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        try(PrintWriter writer = new PrintWriter(fileName)) {
            writer.write(this.data);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
