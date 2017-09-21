package com.automationpractice.stepdef.sprinttwo;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SearchPage;
import com.automationpractice.support.WorldHelper;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchFunctionalityStepDefinition {
	
	private WorldHelper helper;
	private HomePage homePage;
	private SearchPage searchPage;

	public  SearchFunctionalityStepDefinition(WorldHelper helper){
		this.helper = helper;
	}
	
	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	   homePage = helper.getHomePage();
	}

	@When("^I search for : \"([^\"]*)\"$")
	public void i_search_for(String item) throws Throwable {
	   searchPage = homePage.searchForItem(item);
	}

	@Then("^I should see : \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_see_and(String pageTitle, String pageUrl, String itemNames, String message) throws Throwable {
	   Assert.assertTrue(pageTitle  + " was not found", searchPage.validatePageTitle(pageTitle));
	   Assert.assertTrue(pageUrl  + " was not found", searchPage.validatePageUrl(pageUrl));
	   Assert.assertTrue(itemNames  + " was not found", searchPage.validateMessage(itemNames));
	   Assert.assertTrue(message  + " was not found", searchPage.validateMessage(message));
	   
	}


}
