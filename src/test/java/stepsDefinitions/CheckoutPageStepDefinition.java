package stepsDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup =  testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		checkoutPage.checkoutItems();
		//Assertion to extract name from screen and compare with name
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void  verify_user_has_ability_enter_promo()
	{
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());		
	}






}
