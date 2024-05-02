package objectRepositeryOHRM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OHRMHomePage {
	
	WebDriver driver;
	
	   public OHRMHomePage(WebDriver driver) {
		   
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   
	   }
	   
	   


	@FindBy(xpath = "//h6[text()='Dashboard']")
	   private WebElement dashboardTitlElement;
	
	@FindAll(@FindBy(xpath = "//a"))
	private List<WebElement> homePageLinkElements;
	
	
	public List<WebElement> getHomePageLinkElements() {
		try {
			return homePageLinkElements;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public WebElement getDashboardTitlElement() {
		
		try {
			return dashboardTitlElement;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
