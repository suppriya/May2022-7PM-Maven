package testBatches;

import org.junit.Test;

import generalUtilities.ReadProperties;
import testScenarios.TestCases;

public class TestSuites extends TestCases
{
	ReadProperties configData;
	public TestSuites()
	{
		configData = new ReadProperties("TestData/Config.properties");
	}
	@Test
	public void runUserChoice()
	{
		//************************Execution Details********************
		System.out.println("************************Execution Details********************");
		System.out.println("Execution Type : " + configData.readData("ExecutionType").toUpperCase());
		System.out.println("Testing Type :" + configData.readData("TestingType").toUpperCase());
		System.out.println("Browser Name :" + configData.readData("Browser").toUpperCase());
		System.out.println("****************************************************************");
		//*****************************************************************
		if(configData.readData("TestingType").equalsIgnoreCase("SMOKE"))
		{
			smokeSuite();
		}
		else if(configData.readData("TestingType").equalsIgnoreCase("REGRESSION"))
		{
			regressionSuite();
		}
		else
		{
			System.out.println("This "+ configData.readData("TestingType") + " Testing Type is not supported and default smoke suite will be executed");
			smokeSuite();
		}
		
	}
	@Test
	public void smokeSuite()
	{
		System.out.println("TestSuite : SMOKE");
		bookBusTicketAndPrint();
		bookBusTicketAndCheckStatus();
	}
	@Test
	public void regressionSuite()
	{
		System.out.println("TestSuite : REGRESSION");
		bookBusTicketAndPrint();
		bookBusTicketAndCheckStatus();
		bookBusTicketAndTrackService();
		bookBusTicketAndCancelTicket();
		bookBusTicketPrintAndTrackService();
	}

}
