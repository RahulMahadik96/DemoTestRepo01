package objectRepositeryOHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OHRMLoginPage {
	
	WebDriver driver;
	
	   public OHRMLoginPage(WebDriver driver) {
		   
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   
	   }
	   
	   

	  @FindBy(xpath = "//h5[text()='Login']")
	   private WebElement loginPageLogo;
	  
	  @FindBy(name = "username")
	  private WebElement useridElement;
	  
	  @FindBy(name="password")
	  private WebElement passwordElement;
	  
	  @FindBy(xpath = "//button[@type='submit']")
	  private WebElement loginButtonElement;
	
	
	 public WebElement getUseridElement() {
		try {
			return useridElement;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 }


	public WebElement getPasswordElement() {
		try {
			return passwordElement;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}


	public WebElement getLoginButtonElement() {
		try {
			return loginButtonElement;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


		public WebElement getLoginPageLogo() {
	    	
		     try {
				return loginPageLogo;
			} catch (Exception e) {
				
				e.printStackTrace();
				return null;
			}
		      
	   }
	
	
}
