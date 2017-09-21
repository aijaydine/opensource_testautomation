package com.automationpractice.stepdef.sprintthree;

import org.junit.Assert;

import com.automationpractice.pages.ContactUsPage;
import com.automationpractice.support.WorldHelper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ContactUsFunctionalityStepDef {
	
	private WorldHelper helper;
	private ContactUsPage contactPage;

	public ContactUsFunctionalityStepDef(WorldHelper helper){
		this.helper = helper;
	}
	
	
	@When("^I add the following: \"([^\"]*)\",\"([^\"]*)\" ,\"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_add_the_following_and(String subjectHeading, String emailAddress, String orderReference, String message) throws Throwable {
		contactPage = helper.getHomePage().clickOnContactUs().sendAMessage(subjectHeading, emailAddress, orderReference,message);
	    
	}

	@Then("^I should see the following: \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_should_see_the_following(String confirmatoryMessage, String confirmatoryPage) throws Throwable {
	    Assert.assertTrue(confirmatoryMessage + "does not exist",contactPage.validateMessage(confirmatoryMessage));
	    Assert.assertTrue(confirmatoryPage + "does not exist",contactPage.validateMessage(confirmatoryPage));
	}

}
