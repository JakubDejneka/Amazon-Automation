package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class FinalCartPage extends Base{

	WebDriver driver;
	
	@FindBy(css=".a-size-medium.sc-product-title.a-text-bold")
	private WebElement itemInCart;
	
		
	
	public FinalCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement itemInCart(){
		return itemInCart;
	}
	
	
	
	
	
}
