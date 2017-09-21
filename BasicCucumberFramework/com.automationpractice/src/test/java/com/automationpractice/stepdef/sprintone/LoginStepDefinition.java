package com.automationpractice.stepdef.sprintone;

import org.junit.Assert;

import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.support.WorldHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	
	private WorldHelper helper;
	private SignInPage signInPage;
	private MyAccountPage landingPage;
	
	public LoginStepDefinition(WorldHelper helper){
		this.helper = helper;
		
	}

	@Given("^I am on the web application$")
	public void i_am_on_the_web_application() throws Throwable {
		signInPage = helper.getHomePage().clickOnSignIn();
	    
	}

	@When("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_with_email_and_password(String email, String password) throws Throwable {
		landingPage = signInPage.loginInWithDetails(email, password);
		
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void i_should_see(String verificationMessage) throws Throwable {
		Assert.assertTrue( verificationMessage + " was not successful", landingPage.verifyMessage(verificationMessage));
	}
}
