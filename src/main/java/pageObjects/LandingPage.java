package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;

	public LandingPage(WebDriver driver) {

		// Constructor
		this.driver = driver;

	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By increment=  By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");


	public void searchItem(String shortName) {

		driver.findElement(search).sendKeys(shortName);
	}

	public void getSearch(String shortName) {

		driver.findElement(search).getText();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(increment).click();
			i--;
		}		
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}

	public String getPrdouctName() {

		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage() {

		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage() {

		return driver.getTitle();
	}

}
