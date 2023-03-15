package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	
	//public String offerPageProductName;
	public CheckoutPage checkoutPage;
	
	TestContextSetup testContextSetup;
	//Constructer created
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has abilty to enter promo code and place the order")
	public void verify_user_has_abilty_to_enter_promo() {
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		
		
	}
	
	@Then("^user proceed to Checkout and validate the (.+) items in checkout page$")
	public void  Then_user_proceed_to_Checkout_and_validate(String shortName) throws InterruptedException {
		checkoutPage.CheckoutItems();
		
		
	}
	
	
	
	



	 
	
	
	

}
