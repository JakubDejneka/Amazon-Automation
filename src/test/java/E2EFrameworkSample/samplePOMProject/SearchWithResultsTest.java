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

public class SearchWithResultsTest extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(SearchWithResultsTest.class.getName());
	private String textToSearch ="The awakening of intelligence";
	
	 
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("homePage"));	
	}
	
	@Test
	public void successfullSearch() throws IOException, InterruptedException {
		
		
		//enter text in search field and press search button
		HomePage hp = new HomePage(driver);
		hp.searchField().clear();
		hp.searchField().click();
		hp.searchField().sendKeys(textToSearch);
		log.info("Search field is populated with text");
		hp.search();
		
		//navigating to search results page and initializing new object of SearchResultsPage
		SearchResultsPage srp = new SearchResultsPage(driver);		
		// verify that results are displayed:
		Assert.assertTrue(srp.resultBar().isDisplayed());
		log.info("Result bar is displayed. There were results!");
		
		//returning the size of search results in page
		System.out.println(srp.returnElements().size());
		
			
		//enter word to search in link 
		srp.wordToSearchInLink("Freedom from the Known");		
		log.info("Navigated to item details");
		Assert.assertTrue(srp.goBackToResults().isDisplayed());
		
	
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	

}
