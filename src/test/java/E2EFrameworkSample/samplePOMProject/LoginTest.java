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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(LoginTest.class.getName());
 	 
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		log.info("Navigated to url");
	} 
	 
	
	@Test(dataProvider="SearchProvider")
	
	public void login(String email, String password) {
		driver.get(prop.getProperty("homePage"));
		HomePage hp = new HomePage(driver);
		hp.hoverOverloginDropdown();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(hp.signInButton()));
		hp.signInButton().click();		
		
		LoginPage lp = new LoginPage(driver);
		lp.provideEmail().sendKeys(email);
		log.info("Email is provided");
		lp.continueButton().click();
		lp.providePasswordl().sendKeys(password);
		log.info("Password is provided");
		lp.signInButton().click();
		
		// Note: test don't cover two-step authentication
		// Till this moment data provider annotation has done its work. 
		//After this line test may fail because of amount of login attempts made on server.
		
		//Assert.assertEquals(lp.authenticationRequiredMessage().getText().toString(), lp.getMessage());
		
		
	}
	
	@DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
		
    return new Object[][] 
    	{
    		{ "jakub_test@mail2paste.com", "secretPassword!" },
            { "jakub_test2@ofmailer.net", "secretPassword2!"}
          
        };
	} 
		
	
	@AfterTest
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	
	
}
