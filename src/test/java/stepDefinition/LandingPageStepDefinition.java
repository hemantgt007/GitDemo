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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	
	//public String offerPageProductName;
	
	LandingPage landingPage;
	
	TestContextSetup testContextSetup;
	//Constructer created
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
		
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
		Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));

	}

	@When("^user searched with Shortname (.+) and Extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
		
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName =  landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");

	}
	
	@When("Added {string} items of the selected product to cart")
	public void Add_Items_of_Selected_product(String quantity) {
		landingPage.incrementQty(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

	 
	
	
	

}
