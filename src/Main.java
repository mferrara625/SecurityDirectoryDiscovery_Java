import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    static Path fileName = Path.of(
            "/Users/Mike/Documents/windowsDirectory.txt");

    public static void fileScanner(String pathname, int numberOfIndents) throws IOException {
        //Creating a File object for directory
        File directoryPath = new File(pathname);
        //List of all files and directories
        File[] filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner sc = null;
        if(filesList != null) {
            for (File file : filesList) {
                String indentation = "";
                for(int i = 0; i < numberOfIndents; i++){
                    indentation += "-----/";
                }
                Files.writeString(fileName, Files.readString(fileName) + "\n\n"+ indentation+"File name: " + file.getName() +
                        "\n"+ indentation+"File path: " + file.getAbsolutePath() +
                        "\n"+ indentation+"Size :" + file.getTotalSpace() +
                        "\n"+ indentation+"IsDirectory?: " + file.isDirectory() +"\n");


                System.out.println("File name: " + file.getName());
                System.out.println("File path: " + file.getAbsolutePath());
                System.out.println("Size :" + file.getTotalSpace());
                System.out.println("IsDirectory?: " + file.isDirectory());
                if (file.isDirectory()) {
                    numberOfIndents++;
                    String tempPath = pathname;
                    pathname += "/" + file.getName();
                    System.out.println("PathName Test: " + pathname);
                    fileScanner(pathname, numberOfIndents);
                    numberOfIndents--;
                    pathname = tempPath;
                }
                //Instantiating the Scanner class
//                if (file.getName().endsWith(".txt")) {
//                    sc = new Scanner(file);
//                    String input;
//                    StringBuffer sb = new StringBuffer();
//                    while (sc.hasNextLine()) {
//                        input = sc.nextLine();
//                        sb.append(input + " ");
//                    }
//                    System.out.println("Contents of the file: " + sb.toString());
//                }
                System.out.println(" ");
            }
        }
    }
    public static void main(String args[]) throws IOException {


        // Writing into the file
       String path = "C:/Users/Mike/Documents/TestFolder";
       fileScanner(path, 0);
    }
}