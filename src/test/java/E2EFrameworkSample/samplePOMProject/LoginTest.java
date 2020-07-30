package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(SearchWithResultsTest.class.getName());
	 
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		log.info("Window is maximized");
		driver.get(prop.getProperty("homePage"));	
		log.info("Navigated to url");
	}
	
	
	@Test
	public void login() {
		HomePage hp = new HomePage(driver);
		hp.hoverOverloginDropdown();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(hp.signInButton()));
		hp.signInButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.provideEmail().sendKeys(prop.getProperty("email"));
		log.info("Email is provided");
		lp.continueButton().click();
		lp.providePasswordl().sendKeys(prop.getProperty("password"));
		log.info("Password is provided");
		lp.signInButton().click();
		
		Assert.assertEquals(lp.authenticationRequiredMessage().getText().toString(), lp.getMessage());
		
		// dopisać data providera i pododawac logi do tego testu i innych (w tym z bledami log.error?)
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	
	
}
