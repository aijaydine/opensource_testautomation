package com.automationpractice.stepdef.sprinttwo;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import com.automationpractice.support.WorldHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartFunctionalityStepDefinition {
	
	
	private WorldHelper helper;
	private HomePage homePage;
	private ShoppingCartSummaryPage shoppingCartSummaryPage;

	public CartFunctionalityStepDefinition(WorldHelper helper){
		this.helper = helper;
	}
	
	@Given("^I am on my Home Page$")
	public void iAmOnMyHomePage() throws Throwable {
	  homePage = helper.getHomePage();
	}
	
	
	@When("^I open the shopping cart$")
	public void iOpenTheShoppingCart() throws Throwable {
	   shoppingCartSummaryPage = homePage.goToCart();
	}
	
	@Then("^I would see \"([^\"]*)\"$")
	public void iWouldSee(String message) throws Throwable {
	   Assert.assertTrue(message  + "does not exist ", shoppingCartSummaryPage.validateMessage(message));
	}

	
	
}
