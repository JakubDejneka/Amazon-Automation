package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class CartPageBeforeCheckout extends Base{

	WebDriver driver;
	
	@FindBy(id="hlb-view-cart-announce")
	private WebElement cartButton;
	
		
	
	public CartPageBeforeCheckout(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement cartButton(){
		return cartButton;
	}
	
	
	
	
	
}
