package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;

	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals=By.linkText("Top Deals");
	private By increment=By.cssSelector(".increment");
	private By addToCart=By.cssSelector(".product-action button");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealPage() {
		
		driver.findElement(topDeals).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void incrementQty(int quantity) {
		int i=quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}

}
