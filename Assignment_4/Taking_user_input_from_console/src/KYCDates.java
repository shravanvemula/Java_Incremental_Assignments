import java.text.ParseException;
import java.util.*;

/**
 * This class takes in user input from console and uses methods in ValidDateRanges class to find start date and end dates for filling KYC Form.
 *
 */

public class KYCDates {
    private int numberOfDates;
    public ArrayList<String> signedDayDates;
    public ArrayList<String> currentDayDates;
    public KYCDates(){
        numberOfDates=0;
        signedDayDates=new ArrayList<String>();
        currentDayDates=new ArrayList<String>();
    }
    public void setNumberOfDates(int numberOfDates){
        this.numberOfDates=numberOfDates;
    }

    /**
     * I have taken user input in this method , the signup date and present date which is entered in a single line is splitted into
     * two strings and stored in signedDayDates array and currentDayDates array.
     * This method adds date to currentDayDates or presentDayDates only if the dates are in DD-MM-YYYY format using the method isDDMMYYYY()
     */

    public void takeDatesInputAndStore(){
        Scanner scanner=new Scanner(System.in).useDelimiter("\n"); //useDelimiter("\n") considers whole line as one string untill a line break occurs
        for(int i=0;i<numberOfDates;i++){
            String[] currentDates=scanner.next().split(" ");
            if(!isDDMMYYYYFormat(currentDates[0])){
                System.out.println("Please,give Date in the [DD-MM-YYYY] format");
                return;
            }
            signedDayDates.add(currentDates[0]);
            if(!isDDMMYYYYFormat(currentDates[1])){
                System.out.println("Please,give Date in the [DD-MM-YYYY] format");
                return;
            }
            currentDayDates.add(currentDates[1]);

        }

    }
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


    /**
     * splitDates() in ValidDateRanges throws a parseException as we are trying to parse LocalDate objects into strings.
     * @param args
     */

    public static void main(String args[]){
        KYCDates dates=new KYCDates();
        Scanner scanner=new Scanner(System.in);
        int numberOfDates=scanner.nextInt();
        dates.setNumberOfDates(numberOfDates);
        dates.takeDatesInputAndStore();
        ValidDateRanges validDateRanges=new ValidDateRanges();
        try {
            validDateRanges.splitDates(dates.signedDayDates,dates.currentDayDates);
        }
        catch(ParseException e){
            e.printStackTrace();
        }

    }

}