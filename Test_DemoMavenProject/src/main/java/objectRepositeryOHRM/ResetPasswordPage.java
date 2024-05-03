package objectRepositeryOHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
	
	   WebDriver driver;
	   
	   public ResetPasswordPage(WebDriver driver) {
		   
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   		   
	   }
	   
	   @FindBy(xpath = "//h6[text()='Reset Password']")
	   private WebElement resetPassPageLogo;
	   
	   
	   @FindBy(name = "username")
	   private WebElement userIDfiledONRPP;
	   
	   @FindBy(xpath = "//h6[text()='Reset Password link sent successfully']")
	   private WebElement resetPassSuccessMSG;
	   
	   @FindBy(xpath = "//button[text()=' Reset Password ']")
	   private WebElement resetPassButton;

	public WebElement getResetPassButton() {
		try {
			return resetPassButton;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getResetPassPageLogo() {
		try {
			return resetPassPageLogo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getUserIDfiledONRPP() {
		try {
			return userIDfiledONRPP;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getResetPassSuccessMSG() {
		try {
			return resetPassSuccessMSG;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	   
	   
	   
	
	
}