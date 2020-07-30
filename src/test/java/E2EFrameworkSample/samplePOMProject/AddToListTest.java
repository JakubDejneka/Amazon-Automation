package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import resources.Base;

public class AddToListTest extends Base{
	 
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(SearchWithResultsTest.class.getName());
	private String textToSearch ="The awakening of intelligence";
	
	 
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("homePage"));	
		log.info("Navigated to url");
	}
	
	@Test
	public void addToList() { 
		
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
				log.info("Result bar is diplayed. There were results!");
				
				//returning the size of search results in page
				System.out.println(srp.returnElements().size());
				
				
				try{		
				//enter word to search in link 
				srp.wordToSearchInLink("Freedom from the Known");
				WebDriverWait wait = new WebDriverWait(driver, 2);
				wait.until(ExpectedConditions.elementToBeClickable(srp.addToList()));
				
				//add to list
				srp.addToList().click();
				}
				catch(Exception e) {
					System.out.println("Your word was not present in any link! Can not click");
				}
				
			}
			
			
			@AfterTest
			public void tearDown() {
				driver.close();
			}
			
	}


