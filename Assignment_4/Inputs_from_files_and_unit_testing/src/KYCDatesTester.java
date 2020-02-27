import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;



/**
 * This class tests each and every method in KYCDates class using JUnit by performing unit testing.
 * I have used four input files input1.txt,emptyInput.txt,intput3.txt,input4.txt 
 * @author shravan
 *
 */
public class KYCDatesTester {


	KYCDates datesInput1;
	KYCDates datesEmptyInput;
	KYCDates datesInput3;
	KYCDates datesInput4;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		
		datesInput1=new KYCDates("input1.txt");
	    datesEmptyInput=new KYCDates("emptyInput.txt");
	    datesInput3=new KYCDates("input3.txt");
	    datesInput4=new KYCDates("input4.txt");
		
	}

	@Test
	public void testStoreDatesInput()
	{
	

		try {
			datesEmptyInput.storeDatesInput(datesEmptyInput.getInputFile());
			datesEmptyInput.signedDayDates.get(0);
			fail("Check accessing of out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}
		catch(IOException e) {}
		
		//this method may throw IOException as we are using File objects 
		try{
			datesInput1.storeDatesInput(datesInput1.getInputFile());
		}
		catch(IOException e) {}
		
		try{
			datesInput3.storeDatesInput(datesInput3.getInputFile());
		}
		catch(IOException e) {}
		
		
		try {
			datesInput4.storeDatesInput(datesInput4.getInputFile());
		}
		catch(IOException e) {}
		

		assertEquals("datesInput1 : check numberOfDates is correct ", 5, datesInput1.getNumberOfDates());
		assertEquals("datesInput1 : check elements added to signedDayDates is correct ","16-07-1998",datesInput1.signedDayDates.get(0));
		assertEquals("datesInput1 : check elements added to signedDayDates is correct ","04-04-2015",datesInput1.signedDayDates.get(4));
		assertEquals("datesInput1 : check size of signedDayDates is correct ", 5, datesInput1.signedDayDates.size());
		assertEquals("datesInput1 : check elements added to currentDayDates is correct ","27-06-2017",datesInput1.currentDayDates.get(0));
		assertEquals("datesInput1 : check elements added to currentDayDates is correct ","15-03-2016",datesInput1.currentDayDates.get(4));
		assertEquals("datesInput1 : check size of currentDayDates is correct ", 5, datesInput1.signedDayDates.size());
		
		assertEquals("datesInput3 : check numberOfDates is correct ", 2, datesInput3.getNumberOfDates());
		assertEquals("datesInput3 : check elements added to signedDayDates is correct ","31-12-2007",datesInput3.signedDayDates.get(0));
		assertEquals("datesInput3 : check elements added to signedDayDates is correct ","01-03-2014",datesInput3.signedDayDates.get(1));
		assertEquals("datesInput3 : check size of signedDayDates is correct ", 2, datesInput3.signedDayDates.size());
		assertEquals("datesInput3 : check elements added to currentDayDates is correct ","09-09-2014",datesInput3.currentDayDates.get(0));
		assertEquals("datesInput3 : check elements added to currentDayDates is correct ","04-04-2017",datesInput3.currentDayDates.get(1));
		assertEquals("datesInput3 : check size of currentDayDates is correct ", 2, datesInput3.signedDayDates.size());
		
		assertEquals("datesInput3 : check numberOfDates is correct ", 4, datesInput4.getNumberOfDates());
		assertEquals("datesInput3 : check elements added to signedDayDates is correct ","12-12-2000",datesInput4.signedDayDates.get(0));
		assertEquals("datesInput3 : check elements added to signedDayDates is correct ","12-12-2000",datesInput4.signedDayDates.get(1));
		assertEquals("datesInput3 : check size of signedDayDates is correct ", 4, datesInput4.signedDayDates.size());
		assertEquals("datesInput3 : check elements added to currentDayDates is correct ","11-10-2002",datesInput4.currentDayDates.get(2));
		assertEquals("datesInput3 : check elements added to currentDayDates is correct ","13-10-2003",datesInput4.currentDayDates.get(3));
		assertEquals("datesInput3 : check size of currentDayDates is correct ", 4, datesInput4.currentDayDates.size());
		
		
	}
	
	@Test
	public void testISDDMMYYYYFormat() {
	
		assertEquals(" check isDDMMYYYY() is correctly working ",true,datesInput1.isDDMMYYYYFormat("12-12-2000"));
		assertEquals(" check isDDMMYYYY() is correctly working ",false,datesInput1.isDDMMYYYYFormat("2000-12-12"));
		assertEquals(" check isDDMMYYYY() is correctly working ",false,datesInput1.isDDMMYYYYFormat("12/12/2000"));
		assertEquals(" check isDDMMYYYY() is correctly working ",false,datesInput1.isDDMMYYYYFormat("12-12/2000"));
		assertEquals(" check isDDMMYYYY() is correctly working ",false,datesInput1.isDDMMYYYYFormat("12-12-98"));
		assertEquals(" check isDDMMYYYY() is correctly working ",false,datesInput1.isDDMMYYYYFormat("1-12-2000"));
		
		
		
	}
	
	
}
	
	