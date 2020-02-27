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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Regular Expression or \"-1\" to terminate the search : ");
        String regExp = scanner.next();

        while (!regExp.equals("-1")) {
            printRequiredFiles(regExp,directory);
            System.out.print("Enter Regular Expression or \"-1\" to terminate the search : ");
            regExp = scanner.next();

        }
    }

    /**
     * printRequiredFiles() method has two parameters named regExp of type String and directory of type File.
     * This method calls findFiles() method present in DirectoryQueue class which returns an ArrayList of all
     * the files present in all the directories of home directory.Then this method prints the absolute paths
     * of only those files that are matching the given regular expression.
     * @param regExp
     * @param directory
     */
    public void printRequiredFiles(String regExp,File directory){
        int flag=0;
        ArrayList<File> foundFiles =dirQueue.findFiles(regExp,directory);
        System.out.println("Absolute Paths of files found in " + directory.getName() + " matching the regular expression \"" + regExp + "\" are:");
        for (File currentFile : foundFiles){
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

    /**
     * I have taken /home/shravan/Downloads as my home directory since it contains most of the files in my system.
     * @param args
     * @throws IOException
     */
    public static void main(String args[])throws IOException {
        FileSearch fs = new FileSearch();
        File homeDir = new File("/home/shravan/Downloads");
        fs.takeInput(homeDir);

    }

}




