import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void fileScanner(String pathname) throws IOException {
        //Creating a File object for directory
        File directoryPath = new File(pathname);
        //List of all files and directories
        File[] filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner sc = null;
        if(filesList != null) {
            for (File file : filesList) {
                System.out.println("File name: " + file.getName());
                System.out.println("File path: " + file.getAbsolutePath());
                System.out.println("Size :" + file.getTotalSpace());
                System.out.println("IsDirectory?: " + file.isDirectory());
                if (file.isDirectory()) {
                    String tempPath = pathname;
                    pathname += "/" + file.getName();
                    System.out.println("PathName Test: " + pathname);
                    fileScanner(pathname);
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
       String path = "C:/Windows/";
       fileScanner(path);
    }
}