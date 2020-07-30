package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class MainMenuResultsPage extends Base{
	
	
	WebDriver driver;	
	private String linkText;
	String selectedItem;
		
	@FindBy(css =".a-size-medium.s-inline.s-access-title.a-text-normal")
	private List<WebElement> searchResultList;
	
		
	
	public MainMenuResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}		
	
		
	public List<WebElement> searchResultList() {
		return searchResultList;
	}
	
	
	
	
	public void addToCartRandomItem() {
		List<WebElement> myElements = new ArrayList<WebElement>(searchResultList);
		Random rand = new Random();
		System.out.println("Size of List: "+myElements.size());
        for(WebElement e : myElements) 
        {        
            System.out.println(e.getText());              		
	
        }
        
        WebElement x = myElements.get(rand.nextInt(myElements.size()));
        selectedItem=x.getText();
        System.out.println("Take random:" +x.getText());
        x.click();
        
		
	}
	
	public String getItem() {
		return selectedItem;
	}
	
		
	
}

