package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OffersPage {
	public WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		
		// Constructor
		this.driver = driver;
	}
	
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String shortName) {		

		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getPrdouctName() {

		return driver.findElement(productName).getText();
	}
	

}
