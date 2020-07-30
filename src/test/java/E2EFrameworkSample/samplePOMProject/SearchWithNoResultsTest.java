package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import resources.Base;

public class SearchWithNoResultsTest extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(SearchWithNoResultsTest.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.manage().window().maximize();
		log.info("window is maximized");
		driver.get(prop.getProperty("homePage"));	
		log.info("navigated to url");
	}

	@Test
	public void unsuccessfullSearch() throws IOException, InterruptedException {
		
		HomePage hp2 = new HomePage(driver);
		hp2.searchField().clear();
		hp2.searchField().click();
		hp2.searchField().sendKeys("xxxxxxxxx nothing to search xxxxxxxxxx");
		hp2.search();
		
		SearchResultsPage srp2 = new SearchResultsPage(driver);
		log.info("result bar is not displayed- as expected");
		Assert.assertTrue(srp2.emptyResults().isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	

}
