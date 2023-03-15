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
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	public void switchToChildWin() throws InterruptedException {
		// testContextSetup.driver.findElement(By.linkText("Top Deals")).click();

		testContextSetup.pageObjectManager.getLandingPage().selectTopDealPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
		
		// LandingPage landingPage = new LandingPage(testContextSetup.driver);
		// landingPage.selectTopDealPage();

	}

	@Then("^user searched  for (.+) Shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		switchToChildWin();
		// testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		OffersPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		// OffersPage offerPage = new OffersPage(testContextSetup.driver);
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();

	}

	@Then("Validate product name in offer page matches with Landing Page")
	public void validate_product_name_in_offer_page() {
		System.out.println(offerPageProductName);
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);

	}

}
