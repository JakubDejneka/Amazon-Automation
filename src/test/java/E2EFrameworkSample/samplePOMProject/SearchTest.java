package E2EFrameworkSample.samplePOMProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import resources.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(SearchTest.class.getName());
	
	@BeforeMethod
	public void setUp() throws IOException{
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.manage().window().maximize();
		log.info("window is maximized");
		driver.get(prop.getProperty("url"));	
		log.info("navigated to url");
	}
	
	@Test
	public void successfullSearch() throws IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.searchField().clear();
		hp.searchField().click();
		hp.searchField().sendKeys("The awakening of intelligence");
		log.info("text is enetered in search fields");
		hp.go();
		
		SearchResultsPage srp = new SearchResultsPage(driver);		
		// verify that results are displayed:
		Assert.assertTrue(srp.resultBar().isDisplayed());
		log.info("result bar is diplayed. There were results!");
		System.out.println(srp.returnElements().size());
		
		
		for	(WebElement w:srp.returnElements()) {
			String linkText = w.getText();
			//System.out.println(linkText);
			if(linkText.contains("Mindfulness")){
				w.click();
				break;
			};
		}
		
		WebDriverWait w = new WebDriverWait(driver, 2);
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id='wishListMainButton-announce']"))));
		driver.findElement(By.xpath("//a[@id='wishListMainButton-announce']")).click();
	}
	
	@Test
	public void unsuccessfullSearch() throws IOException, InterruptedException {
		
		HomePage hp2 = new HomePage(driver);
		hp2.searchField().clear();
		hp2.searchField().click();
		hp2.searchField().sendKeys("xxxxxxxxx nothing to search xxxxxxxxxx");
		hp2.go();
		
		SearchResultsPage srp2 = new SearchResultsPage(driver);
		log.info("result bar is not displayed- as expected");
		Assert.assertTrue(srp2.emptyResults().isDisplayed());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
