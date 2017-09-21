package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utils.Screenshot;

public class BasePage {
	
	protected  WebDriver driver;
	protected Logger logger;
	protected Screenshot camera;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		logger = LogManager.getLogger("TestLogger");
		camera = new Screenshot(driver);
		
		
	}

}
