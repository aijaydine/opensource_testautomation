package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage{
	
	@FindBy(id="email")
	private WebElement emailAddressElement;
	
	@FindBy(id="id_order")
	private  WebElement orderRefElement;
	
	@FindBy(id="message")
	private WebElement writeMessageElement; 
	
	@FindBy(id="submitMessage")
	private WebElement sendElement;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}

	public ContactUsPage sendAMessage(String subjectHeading, String emailAddress, String orderReference, String message) {
		try{
			logger.info("sendAMessage started excution");
			WebElement subject = driver.findElement(By.id("id_contact"));
			Select select = new Select(subject);
			select.selectByVisibleText(subjectHeading);
			logger.info(subjectHeading + " was successfully selected");
			emailAddressElement.sendKeys(emailAddress);
			logger.info(emailAddress + " was successfully selected");
			orderRefElement.sendKeys(orderReference);
			logger.info(orderReference +":" + " was successfully selected");
			writeMessageElement.sendKeys(message);
			logger.info(message +":" +  " was successfully selected");
			WebElement file = driver.findElement(By.id("fileUpload"));
			file.sendKeys("C:\\Users\\ROS\\Desktop\\AutomationPractice.txt");
			logger.info("file was successfully uploaded");
			sendElement.click();
			logger.info("sendAMessage executed successfully");
			
//			WebElement objectName = driver.findElement(By());to upload file
//			objectName.sendKeys("filepath");
			
		}catch(Throwable t){
			logger.error("file wasn't successfully uploaded" + t);
			logger.error("sendAMessage encountered error" + t);
			camera.takeShot("sendAMessage");
		}
		return PageFactory.initElements(driver, ContactUsPage.class);
		
		
	}

	public boolean validateMessage(String confirmatoryMessage) {
		boolean result = false;
		try{
			logger.info("validateMessage started execution");
			result = driver.getPageSource().contains(confirmatoryMessage);
			logger.info("validateMessage finished execution");
		}catch(Throwable t){
			logger.error("validateMessage encountered error" + t);
			camera.takeShot("validateMessage");
		}
		return result;
	}

}
