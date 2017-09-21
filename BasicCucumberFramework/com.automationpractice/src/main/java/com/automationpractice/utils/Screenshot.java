package com.automationpractice.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	private File scrFile;
	private WebDriver driver;
	
	public Screenshot(WebDriver driver){
		this.driver = driver;
	}
    
    public void takeShot(String screenName){
	 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
    	try {
    		FileUtils.copyFile(scrFile, new File(".src\\main\\resources\\com\\automationpractice\\screenshots\\"+ screenName + ".jpeg"));
    	    //.C:\\Projects\\JavaProject\\Bitbucket projects\\first_java_automation_repo\\BasicCucumberFramework\\com.automationpractice\\//
    	}catch (IOException e1) {
    		e1.printStackTrace();
    	} 
    }

}
