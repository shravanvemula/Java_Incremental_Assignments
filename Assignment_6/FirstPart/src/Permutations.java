import java.util.ArrayList;

public class Permutations
{
    /**
     * This method finds all the permutations of given String with the start index and end index using recursion
     * and stores each permutation into the given arraylist.
     * @param currentNumberStr
     * @param start
     * @param end
     * @param allPermutations
     */

    public void findPermutations(String currentNumberStr, int start, int end, ArrayList<String> allPermutations){
        if(start==end){
            allPermutations.add(currentNumberStr);
        }
        else{
            for(int i=start;i<=end;i++){
                currentNumberStr=swap(currentNumberStr,start,i);
                findPermutations(currentNumberStr,start+1,end,allPermutations);
                currentNumberStr=swap(currentNumberStr,start,i);
            }
        }

    }

    /**
     * This method swaps character at index1 in the given string with character at index2 in the given string
     * @param currentNumberStr
     * @param index1
     * @param index2
     * @return
     */

    public String swap(String currentNumberStr,int index1,int index2){
        StringBuilder currentNumber=new StringBuilder(currentNumberStr);
        char temp=currentNumber.charAt(index1);
        currentNumber.setCharAt(index1,currentNumber.charAt(index2));
        currentNumber.setCharAt(index2,temp);
        return currentNumber.toString();
    }








}
