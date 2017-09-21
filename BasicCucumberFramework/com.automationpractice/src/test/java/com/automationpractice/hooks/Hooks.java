package com.automationpractice.hooks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.automationpractice.support.WorldHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private WorldHelper helper;
	private WebDriver driver;
	
	public Hooks (WorldHelper helper){
		this.helper = helper;
//		this.helper = new WorldHelper();
	}
	
	@Before
	public void startLoginTest(){
		helper.instantiateDrivers();
		helper.setUpBrowser();
		
	}
	
	@After
	
	
	public void closeLoginTest(){
		helper.tearDownBrowser();
	}
	
	
	 public void embedScreenshot(Scenario scenario) { 
		
        if (scenario.isFailed()) {  
            try {  
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); 
                scenario.embed(screenshot, "image/png");  
            } catch (WebDriverException wde) {  
                System.err.println(wde.getMessage());  
            } catch (ClassCastException cce) {  
                cce.printStackTrace();  
            }  
        }
        
       
        
        
//        (ScenarioResult result)
//        {
//            //on failure, embed a screenshot in the test report
//            if(result.isFailed())
//            {
//                byte[] screenshot =  ((TakesScreenshot)driver)
//                    .getScreenshotAs(OutputType.BYTES);
//
//                result.embed(screenshot, "image/png");
//            }
	 } 
	
}
