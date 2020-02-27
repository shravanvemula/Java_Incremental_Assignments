import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

/**
 * This class creates a queue for directories to traverse recursively through each directory of directories.
 * It also creates an ArrayList of all files present in all the directories in my home directory.
 */
public class DirectoryQueue
{
        private Queue<File> queueOfDirectories;
        private ArrayList<File> allFiles;

        /**
         * Constructor to initialize queryOfDirectories and allFiles.
         */

        public DirectoryQueue () {
            queueOfDirectories=new LinkedList<File>();
             allFiles=new ArrayList<File>();
        }

    /**
     * findFiles() method returns an arrayList of allFiles. This method performs Breadth First Search(BFS)
     * by adding each found directory to queue and also adding all the directories of currently found direcory.
     * First I will add my home directory to the queue and then loop untill queue becomes empty and in the loop
     * remove the directory  from start of the queue and assign it to currentDirectory and now
     * use currentDirectory.list() method which returns an array of Files of all the files and directories in the currentDirectory
     * Now, for each file/directory in the array of foundFiles ,if it is a file add it to allFiles ,else if it is a
     * directory add it to the queue of directories. In this way currentDirectory updates to first directory in the queue ,since queue.remove()
     * removes and returns the first directory in the queue.Hence the loop runs untill queue becomes empty.
     *
     * @param regExp
     * @param directory
     * @return
     */
    public ArrayList<File> findFiles(String regExp,File directory)
        {

            File[] foundFiles;
            queueOfDirectories.add(directory);
            while(!queueOfDirectories.isEmpty()) {
                File currentDirectory=queueOfDirectories.remove();
                foundFiles=currentDirectory.listFiles();
                for(File currentFoundFile:foundFiles) {

                    if (currentFoundFile.isDirectory()) {
                        queueOfDirectories.add(currentFoundFile);
                    } else if(currentFoundFile.isFile()){
                        allFiles.add(currentFoundFile);
                    }
                }

            }
            return allFiles;
        }
}
