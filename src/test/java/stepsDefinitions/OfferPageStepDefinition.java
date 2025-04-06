package stepsDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	OffersPage offerPage;
	public String offerPageProductName;
	
	//Single responsibility principle
	//Loosely coupled
	//Factory design pattern
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup =  testContextSetup;
		this.offerPage = testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}	
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();	
		
		offerPage.searchItem(shortName);	
		Thread.sleep(3000);
		offerPageProductName = 	offerPage.getPrdouctName();	    
	}
	
	public void switchToOffersPage()
	{
		//If switched to offer page -> skip the below part
		//if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) 
				
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();

	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page()
	{
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
		
	}



}
