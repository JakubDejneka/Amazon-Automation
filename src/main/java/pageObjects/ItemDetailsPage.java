package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ItemDetailsPage extends Base{

	WebDriver driver;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartButton;
	
	
	
	
	public ItemDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement addToCartButton(){
		return addToCartButton;
	}
	
	
	
	
	
}
