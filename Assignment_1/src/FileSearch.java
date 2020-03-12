import java.io.*;
import java.util.*;

/**
 * Create a java program to search through the home directory and look for files that match a regular expression.
 * The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
 */

/**
 * Description of Code
 * I have written the code in such a way that it searches for files recursively in all the directories through my home directory.
 * I have created two classes FileSearch and DirectoryQueue.
 * FileSearch is to find and print the file paths matching the regular expression and DirectoryQueue creates a queue of
 * all the directories present in my home directory and it helps to traverse through each directory by using Breadth First Search (BFS)
 * strategy .
 *
 */
public class FileSearch {

    private DirectoryQueue dirQueue;

    /**
     * Constructor to instantiate an object to DirectoryQueue
     */

    FileSearch() {
            dirQueue=new DirectoryQueue();
    }

    /**
     * takeInput() method has a parameter named directory which is of type File .
     * This method calls getAllFiles() method present in DirectoryQueue class which returns an ArrayList of all
     * the files present in all the directories of home directory
     * This method takes input from the user, untill user enters -1 .If user enter -1
     * the loop terminates and  user cannot give input.If  user enters a regular expression
     * printRequiredFiles() method will be called to print the absolute paths of files matching
     * the given regular expression.This process continues untill user enters -1.
     * @param directory
     */
    public void takeInput(File directory){
        if (!directory.exists()) {
            System.out.println(directory.getName() + " does not exist");
            return;
        }
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter Regular Expression or \"-1\" to terminate the search : ");
        String regExp = scanner.next();
        ArrayList<File> allFiles =dirQueue.getAllFiles(directory);
        while (!regExp.equals("-1")) {
            printRequiredFiles(regExp,directory,allFiles);
            System.out.print("Enter Regular Expression or \"-1\" to terminate the search : ");
            regExp = scanner.next();

        }
    }
    /**
     * printRequiredFiles() method has three parameters
     * This method prints the absolute paths
     * of only those files that are matching the given regular expression.
     * @param regExp
     * @param directory
     * @param allFiles
     */
    public void printRequiredFiles(String regExp,File directory,ArrayList<File> allFiles){
        int flag=0;

        System.out.println("Absolute Paths of files found in " + directory.getAbsolutePath() + " matching the regular expression \"" + regExp + "\" are:");
        for (File currentFile : allFiles){
            String fileName=currentFile.getName();
            if(fileName.matches(regExp)) {
                flag=1;
                System.out.println(currentFile.getAbsolutePath());
            }
        }
        if(flag==0){
            System.out.println("Sorry,no files found.");
        }
    }


    public static void main(String args[])throws IOException {
        FileSearch fs = new FileSearch();
        Scanner scanner=new Scanner(System.in).useDelimiter("\n");
        String homeDirectory=System.getProperty("user.home");
        File homeDir = new File(homeDirectory);
        fs.takeInput(homeDir);

    }

}




