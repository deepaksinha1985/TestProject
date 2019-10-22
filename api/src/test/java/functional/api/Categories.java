package functional.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import utilities.api.ConstantUtil;
import utilities.api.RestUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Categories extends BaseTest {
	 
	//ExtentReports extent;
	//ExtentTest logger;
	
	public static Response res;   
    
	@BeforeClass
    public void setup ()
    {
       //extent=RestUtil.Report();
       res = RestUtil.getResponse(ConstantUtil.Sandbox_URL + ConstantUtil.Catalogue_false_URL);
        	              
    }

	@Test (priority=1, description="Verify that Name contains Carbon credits")
	public void verifyname()
	{
		logger = extent.startTest("Categories_Acceptance_Criteria_01","Verify Name = Carbon credits");
		logger.log(LogStatus.INFO, "Successfully Getting the GET reponse of Category Details");
			
		JSONObject obj = new JSONObject(res.getBody().asString());
		
		
		//System.out.println(jsonPathEvaluator.get("Name"));
		//Assert.assertEquals(obj.get("Name"), "Carbon credits");
		
		Assert.assertEquals(obj.get("Name"), "Carbon credits");
		logger.log(LogStatus.INFO, "Actual Response: "+obj.toString());
		logger.log(LogStatus.PASS, "Expected value matched with Actual "+ "[Name=Carbon credits]");
		
			
	}
	
	@Test (priority=2, description="Verify that CanRelist contains true value ")
	public void verifyCanRelist()
	{
		logger = extent.startTest("Categories_Acceptance_Criteria_02","Verify CanRelist = true");
		JSONObject obj = new JSONObject(res.getBody().asString());
		
		//System.out.println(jsonPathEvaluator.get("CanRelist").toString());
		Assert.assertEquals(obj.get("CanRelist").toString(), "true");
		logger.log(LogStatus.INFO, "Actual Response: "+obj.toString());
		logger.log(LogStatus.PASS, "Expected value matched with Actual "+ "[CanRelist=true]");
			
	}
	
	@Test (priority=3, description="The Promotions element with Name contains Gallery has a Description that contains the text 2x larger image")
	public void verifyPromotionsdata()
	{
		logger = extent.startTest("Categories_Acceptance_Criteria_03","Verify the Promotions element with Name contains Gallery has a Description that contains the text 2x larger image");
		JSONObject obj = new JSONObject(res.getBody().asString());
		
		JSONArray arraydata1 = obj.getJSONArray("Promotions");
		
		logger.log(LogStatus.INFO, "Actual Response: "+obj.toString());
		
		Assert.assertEquals(arraydata1.getJSONObject(1).get("Name"),"Gallery");
		logger.log(LogStatus.PASS, "Expected value matched with Actual "+ "[Name=Gallery]");
		
		
		Assert.assertTrue(arraydata1.getJSONObject(1).get("Description").toString().contains("2x larger image"));
		logger.log(LogStatus.PASS, "Expected value matched with Actual "+ "[Description contains 2x larger image]");
		
		
		
	}
	
	
	  
	
	

}
