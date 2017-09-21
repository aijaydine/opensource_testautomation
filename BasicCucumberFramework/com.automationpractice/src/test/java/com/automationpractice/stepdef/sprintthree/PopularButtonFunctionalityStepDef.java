package com.automationpractice.stepdef.sprintthree;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.support.WorldHelper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PopularButtonFunctionalityStepDef {
	
	private WorldHelper helper;
	private HomePage homePage;

	public PopularButtonFunctionalityStepDef(WorldHelper helper){
		this.helper = helper;
	}
	
	@When("^I view the popular items$")
	public void iViewThePopularItems() throws Throwable {
	   homePage = helper.getHomePage();
	}

	@Then("^I should see the following: \"([^\"]*)\",\"([^\"]*)\"$")
	public void iShouldSeeTheFollowing(String item, String amount) throws Throwable {
	    Assert.assertTrue(item + "does not exist", homePage.verifyItem(item));
	    Assert.assertTrue( amount + "does not exist", homePage.verifyItem(amount));
	}


}
