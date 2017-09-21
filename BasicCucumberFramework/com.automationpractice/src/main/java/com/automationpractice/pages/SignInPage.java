package com.automationpractice.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
	
	@FindBy(id = "email")
	private WebElement emailButton;
	
	@FindBy(id = "passwd")
	private WebElement passwordButton;
	
	@FindBy(id = "SubmitLogin")
	private WebElement clickLoginButton ;

	public SignInPage(WebDriver driver) {
		super(driver);
		
	}

	public MyAccountPage loginInWithDetails(String email, String password) {
		try{
			logger.info("loginInWithDetails started execution");
			emailButton.sendKeys(email);
			logger.info("email was entered successfully");
			passwordButton.sendKeys(password);
			clickLoginButton.click();
			logger.info("loginInWithDetails executed successfully");
		}catch(Throwable t){
			logger.error("loginInWithDetails encountered error : " + t);
			camera.takeShot("loginInWithDetails");
		}

		return PageFactory.initElements(driver, MyAccountPage.class);	
	}

	public boolean validateThatIamLoggedOutWith(String message) {
		boolean  result = false;
		try{
			logger.info("validateThatIamLoggedOutWith started execution");
			result = driver.getPageSource().contains(message);
			logger.info("validateThatIamLoggedOutWith encountered executed successfully");
		}catch(Throwable t){
			camera.takeShot("validateThatIamLoggedOutWith");
		}
		return result;
		
	}

}
