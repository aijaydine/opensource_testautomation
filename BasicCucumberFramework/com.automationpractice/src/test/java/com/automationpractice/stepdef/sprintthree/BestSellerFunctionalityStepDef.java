package com.automationpractice.stepdef.sprintthree;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.support.WorldHelper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BestSellerFunctionalityStepDef {

	private WorldHelper helper;
	private HomePage homePage;

	public BestSellerFunctionalityStepDef(WorldHelper helper){
		this.helper = helper;
	}
	
	
	@When("^I view items on bestseller$")
	public void iViewItemsOnBestseller() throws Throwable {
	   homePage = helper.getHomePage().selectBestSeller();
	}

	@Then("^I should see the following : \"([^\"]*)\", \"([^\"]*)\"$")
	public void iShouldSeeTheFollowing(String itemNames, String prices) throws Throwable {
		Assert.assertTrue(itemNames + " does not exist", homePage.verifyItem(itemNames));
		Assert.assertTrue(prices + " does not exist", homePage.verifyItem(prices));
	    
	}
}
