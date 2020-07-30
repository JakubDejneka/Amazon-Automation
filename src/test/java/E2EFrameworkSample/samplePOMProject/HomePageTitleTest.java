package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class HomePageTitleTest extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePageTitleTest.class.getName());
	  
	 
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("homePage"));	
	}
	
	@Test
	public void getTitle() {

		HomePage hpt = new HomePage(driver);		
		log.info("Title of page is going to be verified");
		Assert.assertEquals(hpt.displayTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		log.info("Title of page is verified");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	

}
