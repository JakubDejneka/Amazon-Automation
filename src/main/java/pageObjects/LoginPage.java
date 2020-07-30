package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage extends Base {
	 
	WebDriver driver;
	@FindBy(id="ap_email")
	private WebElement emailField;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(id="ap_password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signInButton;
	
	@FindBy(xpath="//h1[contains(text(),'Authentication required')]")
	private WebElement authenticationRequiredMessage;
	
	private final String message = "Authentication required";
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement provideEmail() {
		return emailField;
	}
	
	public WebElement continueButton() {
		return continueButton;
	}
	
	public WebElement providePasswordl() {
		return passwordField;
	}
	
	public WebElement signInButton() {
		return signInButton;
	}
	
	public WebElement authenticationRequiredMessage() {
		return authenticationRequiredMessage;
	}
	
	public String getMessage()
	{
		return message;
	}
	
}

