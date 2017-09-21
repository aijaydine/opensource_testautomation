package com.automationpractice.stepdef.sprinttwo;

import org.junit.Assert;

import com.automationpractice.pages.CasualDressesPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import com.automationpractice.support.WorldHelper;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddtoCartStepDefinition {
	
	private WorldHelper helper;
	private ShoppingCartSummaryPage shoppingCartSummaryPage;

	public AddtoCartStepDefinition(WorldHelper helper){
		this.helper = helper;
	}
	
	@When("^I add the following items:\"([^\"]*)\"&\"([^\"]*)\"$")
	public void iAddTheFollowingItems(String casualDresses, String eveningDresses) throws Throwable {
	   shoppingCartSummaryPage = helper.getMyAccountPage()
			   							.clickOnDresses()
			   							.selectCasualDresses().goToPrintedDress().addCasualDress()
			   							.selectEveningDress()
			   							.goToPrintedEveningDress()
			   							.addEveningDress(eveningDresses);
	}

	@Then("^the following should exist in the cart:\"([^\"]*)\"$")
	public void theFollowingShouldExistInTheCart(String totalAmount) throws Throwable {
		String message = "Your shopping cart is empty.";
		try{
			Assert.assertTrue(totalAmount + "does not exist", shoppingCartSummaryPage.validateMessage(totalAmount));
		}finally{
			helper.getHomePage().goToCart().removeItemsFromShoppingCart().validateMessage(message);
		}
	}

}
