/**
 * 1. A vampire number v is a number with an even number of digits n,
 * that can be factored into two numbers x and y each with n/2 digits and
 * not both with trailing zeroes, where v contains precisely all the digits
 * from x and from y, in any order. Write a java program to print first 100 vampire numbers.
 */

import java.util.ArrayList;

public class VampireNumber
{

    /**
     * This method checks whether the given currentNumber is vampire or not.First it stores all the perumtataions of the
     * given number in an arraylist and divides each permutation into two halves using substring() and then converted into long
     * and checks if multiplication of two halves gives the current Number.It also checks that both halves should not
     * have trailing zeroes and also checks currentNumber has even number of digits.It returns true If number is vampire else false.
     * @param currentNumber
     * @return
     */
    public boolean isVampire(long currentNumber){
        Permutations permutations=new Permutations();
        String currentNumberStr=String.valueOf(currentNumber);
        if(currentNumberStr.length()%2!=0){
            return false;
        }
        ArrayList<String> allPermutations=new ArrayList<String>();
        permutations.findPermutations(currentNumberStr,0,currentNumberStr.length()-1,allPermutations);
        for(String currentPermutationStr:allPermutations){
            String firstHalf=currentPermutationStr.substring(0,currentNumberStr.length()/2);
            long firstHalfValue=Long.parseLong(firstHalf);
            String secondHalf=currentPermutationStr.substring(currentNumberStr.length()/2);
            long secondHalfValue=Long.parseLong(secondHalf);
            if(firstHalf.charAt(firstHalf.length()-1)=='0' && secondHalf.charAt(secondHalf.length()-1)=='0'){
                return false;
            }

            if(firstHalfValue*secondHalfValue == currentNumber){
                return true;
            }
        }
        return false;
    }

    /**
     * This method prints first 100 vampire numbers by checking each number with isVampire() method
     */
    public void printVampireNumbers(){

        long currentNumber=10;
        int countOfVampireNumbers=1;
        System.out.println("First 100 Vampire numbers are:");
        while(countOfVampireNumbers<=100){
            if(isVampire(currentNumber)){
                System.out.println(currentNumber);
                countOfVampireNumbers++;
            }
            currentNumber++;
      }
    }
    public static void main(String args[]){
        VampireNumber vampireNumber=new VampireNumber();
        vampireNumber.printVampireNumbers();
    }
}
