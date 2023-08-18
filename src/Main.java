import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    static Path fileName = Path.of(
            "/Users/Mike/Documents/windowsDirectory.txt");

    public static void main(String args[]) throws Exception {
       String path = "C:/Users/Mike/Documents/TestFolder";
       FileScanner fs = new FileScanner(fileName);
       fs.fileScanner(path, 0);
       EmailSender eSend = new EmailSender("test@test.com", "password");
       eSend.sendMessage();
       File directoryPath = new File(Main.fileName.toUri());
       directoryPath.deleteOnExit();

    }
}