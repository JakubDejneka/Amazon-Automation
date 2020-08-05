package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);  
		// if I want to run it from Jenkins configurations- use System.getProperty. In other cases use prop.getProperty!
		String browserName = prop.getProperty("browser");
		//String browserName = System.getProperty("browser");
		// mvn test -Dbrowser = chrome
		
		System.out.println(browserName);		
		
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");					
		 driver = new ChromeDriver();
		}
		
		
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
	//data provider for RestAssuredParametrizedTest test
	@DataProvider(name = "DataForPost")
	public  Object[][] dataForPost() {
		
		return new Object[][] {
			
			//test data
			{"Jakub","Automation Tester"},
			{"Adam","Java Developer"}
						
		};
	}

	

}
