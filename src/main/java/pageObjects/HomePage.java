package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class HomePage extends Base{
	
	 
	WebDriver driver;
	private By searchField = By.id("twotabsearchtextbox");
	private By searchIcon = By.xpath("//div[@class='nav-search-submit nav-sprite']");
	
	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	private WebElement loginDropdown;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	private WebElement signInButton;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement searchField() {		
		return driver.findElement(searchField);
	}	
	
	public void search() {		
		 driver.findElement(searchIcon).click();;
	}	
	
	public String displayTitle() {
		return driver.getTitle();
	}
	
	public void hoverOverloginDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(loginDropdown).build().perform();
		
	}
	
	public WebElement signInButton() {
		return signInButton;
	}
	
	
}
