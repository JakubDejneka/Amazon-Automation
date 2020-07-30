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
	private String textToSearch ="xxxxxxxxx nothing to search xxxxxxxxxx";
	
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("homePage"));	
	}

	@Test
	public void unsuccessfullSearch() throws IOException, InterruptedException {
		
		HomePage hp2 = new HomePage(driver);
		hp2.searchField().clear();
		hp2.searchField().click();
		hp2.searchField().sendKeys(textToSearch);
		log.info("Search field is populated with text");
		hp2.search();
		
		SearchResultsPage srp2 = new SearchResultsPage(driver);
		log.info("Result bar is not displayed- as expected");
		Assert.assertTrue(srp2.emptyResults().isDisplayed());
		
	}
	 
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	 

}
