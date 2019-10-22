package functional.api;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import utilities.api.RestUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 

{
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void InitialSetup ()
    {
       extent=RestUtil.Report();
    	              
    }
	
	@AfterMethod
	 public void getResult(ITestResult result)
	 {
	 if(result.getStatus() == ITestResult.FAILURE)
	 {
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 }
	 extent.endTest(logger);
	 }
	 
	 @AfterTest
		public void endReport()
	  {
			
	                extent.flush();
	                extent.close();
	    }
	
	
	

}
