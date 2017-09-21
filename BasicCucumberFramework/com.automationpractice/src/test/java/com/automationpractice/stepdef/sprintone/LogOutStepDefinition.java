package com.automationpractice.stepdef.sprintone;

import java.util.List;

import org.junit.Assert;

import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.support.WorldHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LogOutStepDefinition {
	
	private WorldHelper helper;
	private MyAccountPage landingPage;
	private SignInPage signInPage;
	
	
	public LogOutStepDefinition(WorldHelper helper){
		this.helper = helper;
		
	}
	
	
	@Given("^I am logged in the web application$")
	public void i_am_logged_in_the_web_application(DataTable table) throws Throwable {
	   List<List<String>>loginDetails = table.raw();
	   String email = loginDetails.get(1).get(0);
	   String password = loginDetails.get(1).get(1);
//	   String logInMessage = loginDetails.get(1).get(2);
	   
	   landingPage = helper.getHomePage().clickOnSignIn().loginInWithDetails(email, password);
	 
	}

	
	@When("^I log out of the web application$")
	public void iLogOutOfTheWebApplication() throws Throwable {
	   signInPage = landingPage.logoutFromTheApplicationAfterLoggingOn();
	}
	
	@Then("^I validate logout message as \"([^\"]*)\"$")
	public void iValidateLogoutMessageAs(String message) throws Throwable {
		Assert.assertTrue("Test was not successful",signInPage.validateThatIamLoggedOutWith(message));
	}


}
