package com.automationpractice.support;

import org.openqa.selenium.support.PageFactory;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;


public class WorldHelper extends Browsers {
	
	private HomePage homePage;
//	private WorldHelper helper;
	private MyAccountPage myAccountPage;

	
	
	public HomePage getHomePage(){
		if(homePage == null){
			homePage = PageFactory.initElements(driver, HomePage.class);
		}
		return homePage;
	}
	
	public MyAccountPage getMyAccountPage(){
		if(myAccountPage == null){
			myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		}
		return myAccountPage;
	}
}
