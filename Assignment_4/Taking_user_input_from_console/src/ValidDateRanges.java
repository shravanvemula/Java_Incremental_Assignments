import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class finds out valid date ranges to fill the KYC form from given signup dates and current dates.
 * This class's methods are only called if the dates are in DD-MM-YYYY Format and Input is not empty.
 */

class ValidDateRanges
{

    ArrayList<String> dateRanges;
    public ValidDateRanges() {
        dateRanges=new ArrayList<String>();

    }

    /**
     * This method first splits the given dates into an array of strings containing day,month,year of each date and
     * it converts all the Day,Month,Year of each date which are of type Strings into Integers using Integer.parseInt() and stores them
     * in an integer array for signed date and present date.
     * Now, it calls findValidDateRanges to find the dates and calls printValidDateRanges() to print the dates.
     * @param signedDates
     * @param currentPresentDayDates
     * @throws ParseException
     */

    public void splitDates(ArrayList<String> signedDates,ArrayList<String> currentPresentDayDates) throws ParseException {
        for(int i=0;i<signedDates.size();i++) {
            String[] splittedSignedDate=signedDates.get(i).split("-");
            String[] splittedPresentDate=currentPresentDayDates.get(i).split("-");

            int[] splittedSignedDateValues=new int[3];
            int[] splittedPresentDateValues=new int[3];
            for(int j=0;j<3;j++) {
                splittedSignedDateValues[j]=Integer.parseInt(splittedSignedDate[j]);
                splittedPresentDateValues[j]=Integer.parseInt(splittedPresentDate[j]);
            }
            try {
                findValidDateRanges(splittedSignedDateValues, splittedPresentDateValues);
            }
            catch(DateTimeException e){
                System.out.println("Invalid Date");
            }

        }
        printValidDateRanges();
    }
    /**
     * This method first checks whether signed date and present date belongs to the same year.Now,it creates LocalDate
     * objects for signed date and present date using LocalDate.of(int year,int month,int day) method.Now ,two LocalDate objects are created in
     * the format[YYYY-MM-DD]. By using LocalDate's methods LocalDateObject.plusDays(long days),LocalDateObject.plusYears(long years),
     * LocalDateObject.minusDays(long days), start date and end date for filling KYC form are calculated.
     * Now ,this start date and end date are in the format[YYYY-MM-DD] ,hence they are converted to
     * [DD-MM-YYYY] format using the method toDDMMYYYYFormat().Finally the valid date range is added to the arraylist
     * @param signedDateValues
     * @param presentDateValues
     */
        public void findValidDateRanges(int[] signedDateValues,int[] presentDateValues){

            // present date and signup date should have atleast one year difference.
            long yearDifference=(long)(presentDateValues[2]-signedDateValues[2]);
            if(yearDifference<=0){
                dateRanges.add("No Range");
                return;
            }
            //creating LocalDate Objects
            LocalDate signedDate=LocalDate.of(signedDateValues[2],signedDateValues[1],signedDateValues[0]);
            LocalDate presentDate=LocalDate.of(presentDateValues[2],presentDateValues[1],presentDateValues[0]);

            LocalDate startDate=signedDate.plusYears(yearDifference).minusDays(30);
            LocalDate endDate=signedDate.plusYears(yearDifference).plusDays(30);


            /*

                * If startDate is greater than presentDate then we have to find the previous
               * year's +-30 window
               * For Example, assuming today is 14th Jan 2003 and I had signed up on 12th Dec 2000,
               * my window for KYC submission this year should be 12 Nov 2002 to 11 Jan 2003.
               * Since it is already 14th Jan - I will back-date the endDate to presentDate.

            */
            if(startDate.compareTo(presentDate)>0)
            {
                if(yearDifference==1){      //Anniversary has not completed
                    dateRanges.add("No Range");
                    return;
                }
                if(yearDifference>1){
                   startDate=startDate.minusYears(1);
                   endDate=endDate.minusYears(1);

                }

            }
            //if endDate is greater than present date and start date is lower than present date then
            //present date becomes the end date.
            if(endDate.compareTo(presentDate)>0 && startDate.compareTo(presentDate)<=0)
            {
                endDate=presentDate;
            }
            String startDateString=toDDMMYYYYFormat(startDate.toString());
            String endDateString=toDDMMYYYYFormat(endDate.toString());

            dateRanges.add(startDateString+" "+endDateString);
        }
    /**
     * This method converts the dates in the format[YYYY-MM-DD] ,to
     * [DD-MM-YYYY] format.
     * @param date
     * @return
     */

    public String toDDMMYYYYFormat(String date){
        String[] splittedDate=date.split("-");
        date="";
        date=splittedDate[2]+"-"+splittedDate[1]+"-"+splittedDate[0];
        return date;

    }

    public void printValidDateRanges() {
        for(String currentDates:dateRanges) {
            System.out.println(currentDates);
        }
    }

}
