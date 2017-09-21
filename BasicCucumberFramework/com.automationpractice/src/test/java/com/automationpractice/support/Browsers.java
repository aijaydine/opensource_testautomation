package com.automationpractice.support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automationpractice.support.Drivers;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Browsers {
	
	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static InputStream fis;
	protected static Logger logger = LogManager.getLogger("TestLogger");


	public void instantiateDrivers(){
		if(driver == null){
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectRepository.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(config.getProperty("browser").equals("firefox")){
				driver = new FirefoxDriver();
		}else if(config.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", Drivers.chromePath);
				driver = new ChromeDriver();
		}else if(config.getProperty("browser").equals("ie")){
			System.setProperty("webdriver.ie.driver", Drivers.iePath);
				driver = new InternetExplorerDriver();		
		}else if(config.getProperty("browser").equals("headless browser")){
				driver = new HtmlUnitDriver(BrowserVersion.CHROME);
			((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		}else if(config.getProperty("browser").equals("phantomJS")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Drivers.phantomPath);
			caps.setJavascriptEnabled(true);
			caps.setCapability("takeScreenshot", true);
			driver = new PhantomJSDriver(caps);
		}
	}
}
	
	public void setUpBrowser() {
		try{
			logger.info("Browser started successfully");
			driver.manage().window().maximize();
			logger.info("Browser maximized successfully");
			driver.navigate().to(config.getProperty("base_url"));
			logger.info("Browser has navigated to " + config.getProperty("base_url"));
		}catch(Throwable t){
			logger.error("Browser wasn't set up properly :" + t);
		}
		
	}

	public void tearDownBrowser() {
		try{
			logger.info("tearDownBrowser started execution");
			driver.quit();
			logger.info("Browser closed successfully");
			driver = null;
			logger.info("Browser has no value");
			logger.info("-------------------------------------------------------------------------");
		}catch(Throwable t){
			logger.error("Browser wasn't closed properly : " + t);
		}
	}
	
	
}