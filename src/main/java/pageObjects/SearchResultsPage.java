package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class SearchResultsPage extends Base{
	
	
	WebDriver driver;	
		
	@FindBy(xpath ="//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
	private WebElement searchResultBar;
	
	@FindBy(xpath="//span[@cel_widget_id='MAIN-TOP_BANNER_MESSAGE']")
	private WebElement noResults;
	
	@FindBy(css=".a-link-normal.a-text-normal:first-child")
	private List<WebElement> elementsInList;
	
	
		
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}		
	
	public WebElement resultBar() {
		return searchResultBar;
	}
	
	public WebElement emptyResults() {
		return noResults;
	}
	
	public List<WebElement> returnElements() {
		return elementsInList;
	}
	
}
