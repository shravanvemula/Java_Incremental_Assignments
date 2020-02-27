import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * This class takes in user input and uses methods in ValidDateRanges class to find start date and end dates for filling KYC Form
 * Unit testing is done and valid date ranges are also printed to the console for each input file.
 */

public class KYCDates {
    private int numberOfDates;
    private File inputFile;
    public ArrayList<String> signedDayDates;
    public ArrayList<String> currentDayDates;
    
    public KYCDates(String fileName){
        signedDayDates=new ArrayList<String>();
        currentDayDates=new ArrayList<String>();
        inputFile=new File(fileName);
    }
   
    public File getInputFile() {
    	return inputFile;
    }
    public int getNumberOfDates(){
    	return numberOfDates;
    }

    /**
     * I have extracted inputs from the input files the such as signup date and present date which are  in a single line is splitted into
     * two strings and stored in signedDayDates array and currentDayDates array.
     * Since ,the first line contains numberOfDates value , I have used a variable lineNumber to know which line I'm extracting.
     * This method adds date to currentDayDates or presentDayDates only if the dates are in DD-MM-YYYY format using the method isDDMMYYYY()
     */
    public void storeDatesInput(File file) throws IOException{
        //Scanner scanner=new Scanner(System.in).useDelimiter("\n"); //useDelimiter("\n") considers whole line as one string untill a line break occurs
    	FileReader fr=new FileReader(file);
    	BufferedReader br=new BufferedReader(fr);
    	int lineNumber=1;
    	String line="";
        while((line=br.readLine())!=null){
        	if(lineNumber==1) {
        		numberOfDates=Integer.parseInt(line);
        		
        	}
        	else {
            String[] currentDates=line.split(" ");
            if(!isDDMMYYYYFormat(currentDates[0])){
                System.out.println("Please,give Date in the [DD-MM-YYYY] format in "+getInputFile());
                return;
            }
            signedDayDates.add(currentDates[0]);
            if(!isDDMMYYYYFormat(currentDates[1])){
                System.out.println("Please,give Date in the [DD-MM-YYYY] format in "+getInputFile());
                return;
            }
            currentDayDates.add(currentDates[1]);
          }
          lineNumber++;
        }

    }
    /**
     * This method returns true if Date is in DD-MM-YYYY format  else it returns false
     * @param date
     * @return
     */
    
    public boolean isDDMMYYYYFormat(String date) {
    	
    	if(date.length()!=10) {
    		return false;	
    	}
    	int countOfHyphen=0;
    	for(int i=0;i<date.length();i++) {
    		if(date.charAt(i)=='-') {
    			countOfHyphen++;
    		}
    	}
    	if(countOfHyphen!=2) {
    		return false;
    	}

    	String[] splittedDate=date.split("-");
    	if(splittedDate[0].length()!=2)
    	{
    		return false;
    	}
    	if(splittedDate[1].length()!=2)
    	{
    		return false;
    	}
    	if(splittedDate[2].length()!=4)
    	{
    		return false;
    	}
    	
    	return true;
    }
    

}