package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import resources.Base;

public class HomePageTitleTest extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePageTitleTest.class.getName());
	
	
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.manage().window().maximize();
		log.info("window is maximized");
		driver.get(prop.getProperty("url"));	
		log.info("navigated to url");
	}
	
	@Test
	public void getTitle() {

		HomePage hpt = new HomePage(driver);		
		log.info("title of page is going to be verified");
		Assert.assertEquals(hpt.displayTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		log.info("title of page is verified");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	

}
