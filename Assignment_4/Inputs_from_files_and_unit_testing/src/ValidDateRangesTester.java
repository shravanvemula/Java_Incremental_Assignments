import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests each and every method in ValidDateRanges class using JUnit by performing unit testing.
 * @author shravan
 *
 */

public class ValidDateRangesTester {


	KYCDates datesInput1;
	KYCDates datesInput3;
	KYCDates datesInput4;

	
	ValidDateRanges input1;
	ValidDateRanges input3;
	ValidDateRanges input4;

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		
		datesInput1=new KYCDates("input1.txt");
	    datesInput3=new KYCDates("input3.txt");
	   datesInput4=new KYCDates("input4.txt");
		try{
			datesInput1.storeDatesInput(datesInput1.getInputFile());  //dates are extracted from file and stored in arraylists
		
		}
		catch(IOException e) {}
	  
		try{
			datesInput3.storeDatesInput(datesInput3.getInputFile()); //dates are extracted from file and stored in arraylists
		}
		catch(IOException e) {}
		try{
			datesInput4.storeDatesInput(datesInput4.getInputFile()); //dates are extracted from file and stored in arraylists
		}
		catch(IOException e) {}
	
	    input1=new ValidDateRanges();
	    input3=new ValidDateRanges();
	    input4=new ValidDateRanges();
	 
		
	}

	@Test
	public void testSplitDatesAndFindValidDateRanges()
	{
		// this method may throw ParseException as we are parsing LocalDate objects into Strings 
		try {
			input1.splitDates(datesInput1.signedDayDates,datesInput1.currentDayDates);
		}
		catch(ParseException e) {}
	

		assertEquals("input1 : check output size is correct ", 5, input1.dateRanges.size());
		assertEquals("input1 : check date ranges are correct ","16-06-2017 27-06-2017",input1.dateRanges.get(0));
		assertEquals("input1 : check date ranges are correct ","05-01-2017 06-03-2017",input1.dateRanges.get(1));
		assertEquals("input1 : check date ranges are correct ","No Range",input1.dateRanges.get(2));
		assertEquals("input1 : check date ranges are correct ","05-03-2016 04-04-2016",input1.dateRanges.get(3));
		assertEquals("input1 : check date ranges are correct ","05-03-2016 15-03-2016",input1.dateRanges.get(4));
		
		try {
			input3.splitDates(datesInput3.signedDayDates,datesInput3.currentDayDates);
		}
		catch(ParseException e) {}
		
		assertEquals("input3 : check output size is correct ",2, input3.dateRanges.size());
		assertEquals("input3 : check date ranges are correct ","01-12-2013 30-01-2014",input3.dateRanges.get(0));
		assertEquals("input3 : check date ranges are correct ","30-01-2017 31-03-2017",input3.dateRanges.get(1));
		
		try {
			input4.splitDates(datesInput4.signedDayDates,datesInput4.currentDayDates);
		}
		catch(ParseException e) {}
		
		assertEquals("input4 : check output size is correct ",4, input4.dateRanges.size());
		assertEquals("input4 : check date ranges are correct ","No Range",input4.dateRanges.get(0));
		assertEquals("input4 : check date ranges are correct ","12-11-2001 11-01-2002",input4.dateRanges.get(1));
		assertEquals("input4 : check date ranges are correct ","13-10-2002 12-12-2002",input4.dateRanges.get(2));
		assertEquals("input4 : check date ranges are correct ","13-10-2003 12-12-2003",input4.dateRanges.get(3));
	}
	
	@Test

	public void testToDDMMYYYYFormat() {
		assertEquals(" check toDDMMYYYY() is correctly working ","12-12-2000",input1.toDDMMYYYYFormat("2000-12-12"));
		assertEquals(" check toDDMMYYYY() is correctly working ","01-09-1998",input1.toDDMMYYYYFormat("1998-09-01"));
	}
	

	
}