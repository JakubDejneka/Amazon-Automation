package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CartPageBeforeCheckout;
import pageObjects.FinalCartPage;
import pageObjects.HomePage;
import pageObjects.ItemDetailsPage;
import pageObjects.MainMenuResultsPage;
import resources.Base;

public class AddToCartRandomItemsTest extends Base{
	
	
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(AddToCartRandomItemsTest.class.getName());
 	 
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("homePage"));
		log.info("Navigated to url");
	}
	
	
	@Test
	public void addToCart() {
		
		
		HomePage hp = new HomePage(driver);
		hp.mainMenu().click();
		hp.smartHome().click();
		hp.speakers().click();
		
		MainMenuResultsPage mmrp = new MainMenuResultsPage(driver);
		mmrp.addToCartRandomItem();
		
		ItemDetailsPage idp = new ItemDetailsPage(driver);
		idp.addToCartButton().click();		
		
		CartPageBeforeCheckout cp = new CartPageBeforeCheckout(driver);
		cp.cartButton().click();
		
		FinalCartPage fcp = new FinalCartPage(driver);
		
		Assert.assertEquals(mmrp.getItem(), fcp.itemInCart().getText());
		System.out.println("Assertion is completed!" );
		System.out.println("==========================");
		System.out.println(mmrp.getItem());
		System.out.println("is equal to this below :");
		System.out.println(fcp.itemInCart().getText());
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
	

}
