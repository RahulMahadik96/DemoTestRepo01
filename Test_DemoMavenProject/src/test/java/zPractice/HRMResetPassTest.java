package zPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepositeryOHRM.OHRMLoginPage;
import objectRepositeryOHRM.ResetPasswordPage;
import resources.Base;

public class HRMResetPassTest extends Base {
	
	 WebDriver driver;
	 OHRMLoginPage ohmL;
	 ResetPasswordPage rpP;
	 
	 @BeforeClass
	 public void setup() throws IOException {
		 
		 driver=initializeDriver();
		 
		 ohmL=new OHRMLoginPage(driver);
		 
		 rpP=new ResetPasswordPage(driver);
		 
		 
	 }
	 
	 @Test
	 public void resetPasswordTest() throws InterruptedException {
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 
		 System.out.println("Title: "+ driver.getTitle());
		 
		 ohmL.getUseridElement().sendKeys("admin");
		 ohmL.getPasswordElement().sendKeys("12353");
		 
		 ohmL.getLoginButtonElement().click();
		 
		 Thread.sleep(3000);
		 
		 ohmL.getForgotPassLink().click();
		 
		 Thread.sleep(3000);
		 
		 boolean resetPassPageIsOpen= rpP.getResetPassPageLogo().isDisplayed();
		 
		 Assert.assertTrue(resetPassPageIsOpen,"StepFail: we are not on the Reset Password page");
		 
		 System.out.println("StepPass: We are on the ResetPassword page ");
		 
		 rpP.getUserIDfiledONRPP().sendKeys("admin");
		 rpP.getResetPassButton().click();
		 
		 Thread.sleep(3000);
		 
		 boolean successMSGIsDisplayed=rpP.getResetPassSuccessMSG().isDisplayed();
		 
		 Assert.assertTrue(successMSGIsDisplayed, "StepFail: Reset Password Unsuccessful");
		 
		 System.out.println("StepPass: Successfully Reset Password");
		 
		 Thread.sleep(3000);
		 
	 }
	 
	 @AfterClass
	 public void closeBrowser() {
		 
		 driver.quit();
	 }
	
	

}
