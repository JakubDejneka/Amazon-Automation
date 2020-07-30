package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HomePage extends Base{
	
	
	WebDriver driver;
	private By searchField = By.id("twotabsearchtextbox");
	private By searchIcon = By.xpath("//div[@class='nav-search-submit nav-sprite']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement searchField() {		
		return driver.findElement(searchField);
	}	
	
	public void go() {		
		 driver.findElement(searchIcon).click();;
	}	
	
	public String displayTitle() {
		return driver.getTitle();
	}
	
	
}
