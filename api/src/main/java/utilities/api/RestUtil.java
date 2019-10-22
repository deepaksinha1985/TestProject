package utilities.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
 
 
public class RestUtil {
    
   
    public static Response res;
    
    public static String autodate ()
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");  
        Date date = new Date(); 
        
        String auto =formatter.format(date);
        
        return auto;
    }
    
    
    
    public static ExtentReports Report ()
    {
    	ExtentReports extent=null;
    	
    	 extent = new ExtentReports (System.getProperty("user.dir") +"/ExtentReport/Report.html", true);
    	 extent.addSystemInfo("QA", "REST API Automation");
    	 extent.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReport\\ExtentConfig.xml"));
    	     	
    	return extent;
    	
    	
    }
        
    public static Response getResponse (String URI)
    {
        res=given().when().get(URI);
        return res;
    }
 
}
