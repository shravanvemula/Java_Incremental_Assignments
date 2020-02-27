import java.util.*;

/**
 * This class Analyzer, analyze the given input string,whether it contains all alphabets or not.
 *
 * Time taken by the program to execute is given by f(n)= n+1+n+n+n+26+27 (I have mentioned in comments after each statement)
 * I have ignored all the other statements as they consume constant amount of time.So f(n) = 4n+54 which increases linearly
 * with the length of input ,so time complexity is O(n).
 *
 * I have used an array counts of size 26 which occupies 4*26 = 104 bytes and Four int variables n,i,indexInCounts
 * occupies 12 bytes and boolean variable result which occupies 4 bytes and String input of size n that occupies
 * n bytes and Scanner object for Scanner which occupies 16 bytes,analyzer object for Analyzer class which occupies 16 bytes
 * So Total Space occupied is 104+12+4+16+16+n bytes which is 142+n bytes which linealy increase with the value of n,hence
 * it is called Linear Space Complexity.So the space complexity will be O(n).
 *
 */
public class Analyzer {
    /**
     * The following method containsAllAlphabets has a parameter 'input' of type String,which is user
     * input.String input is converted to LowerCase as mentioned in the question case-insensitive.
     * This method returns true, if input has all alphabets ,else it returns false if input doesn't have
     * all alphabets. I have created an array named counts of size 26 , it stores counts of occurences
     * of each alphabet in the input.Values in counts array is initialized to zero.
     *
     * In this method major implementation lies in finding the index in counts array to be incremented, which is indexInCounts.
     * This index can found by using ascii values of characters. Suppose, while iterating through the given
     * input ,we came across character 'b' ,it means second index of counts (counts[1]) should be incremented
     * Ascii character of 'b' is 98 and Ascii character of 'a' is 97 ,so 98-97 gives you 1 which is the required
     * index of counts array and hence we need to subtract every occured character's ascii value with ascii value
     * of 'a' to get the required index.
     *
     * If input doesn't contain character 'z' ,then the value at index 25 does not increase,it will be zero as initialized.
     * If atleast one value in the counts array is zero ,then the method returns false,otherwise  it returns true.
     * @param input
     * @return
     */
    public boolean containsAllAlphabtes(String input) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        input = input.toLowerCase();
        int n=input.length();
        for (int i = 0; i < n; i++) {       //this loop executes for n+1 times
            if(input.charAt(i)>='a' && input.charAt(i)<='z') {     //this condition executes for n times
                int indexInCounts = input.charAt(i) - 'a';         // this statement executes for n times
                counts[indexInCounts]++;                           // this statements exectues for n times
            }
        }
        for (int i = 0; i < counts.length; i++) {     //this loops executes for 27 times
            if (counts[i] == 0) {       //this if condition executes for 26 times if string contains all alphabets
                return false;
            }
        }
        return true;
    }

   
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in).useDelimiter("\n");   //useDelimiter("\n")  allows you to take input containing spaces untill a line break occurs.
        Analyzer analyzer=new Analyzer();
        System.out.print("Enter Input String:");
        String input=scanner.next();
        boolean result=analyzer.containsAllAlphabtes(input);

        if(result==true){
            System.out.println("\""+input+"\" contain all alphabets");
        }
        else{
            System.out.println("\""+input+"\" does not contain all alphabets");
        }
    }
}
