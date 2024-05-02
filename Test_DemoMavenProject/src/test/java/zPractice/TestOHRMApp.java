package zPractice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonLibraries.ExcelLibrary;
import objectRepositeryOHRM.OHRMHomePage;
import objectRepositeryOHRM.OHRMLoginPage;
import resources.Base;


public class TestOHRMApp extends Base {
	
	public WebDriver driver;
	OHRMLoginPage hrmL;
	OHRMHomePage  hrmH;
	ExcelLibrary xlLibrary;
	
	@BeforeTest
	public void browserSetup() throws IOException {
		
		driver = initializeDriver();
		
		hrmL=new OHRMLoginPage(driver);
		hrmH=new OHRMHomePage(driver);
		
		xlLibrary=new ExcelLibrary();
		xlLibrary.LoadAllExcelData();
		
		
	}
	
	@Test
	public void firstTestNGTest() throws InterruptedException, IOException {
		
		
			
			
			
		
			driver.get("https://opensource-demo.orangehrmlive.com/");			
				
			String title=driver.getTitle();
			System.out.println("Title is: "+ title);
			
			
			for(int i=0;i<xlLibrary.getUnames().size();i++ ) {
				
			String userName=xlLibrary.getUnames().get(i);
			String password=xlLibrary.getPwords().get(i);
		    
			
			Assert.assertEquals(title,"OrangeHRM", "StepFail: Unable to launch Web app ");		
			System.out.println("StepPass: Web app successfully launched ");
			
			
		     
		     
		    boolean loginIsDisplayed= hrmL.getLoginPageLogo().isDisplayed();
		    			    
		    Assert.assertTrue(loginIsDisplayed, "StepFail: login page is not open" );
		    
		    System.out.println("StepPass: we are on the Login page");

		    
		    hrmL.getUseridElement().sendKeys(userName);

		    hrmL.getPasswordElement().sendKeys(password);
		    		    
		    hrmL.getLoginButtonElement().click();
		     		    
		  //  boolean dashbordIsVisible=hrmH.getDashboardTitlElement().isDisplayed();
		    
		    //
		    
		  // Assert.assertTrue(dashbordIsVisible, "StepFail: unable to Login " );
		    if(userName=="admin") {
		    	
		    	boolean dashbordIsVisible= driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		    
		    if(dashbordIsVisible==true) {
		    	System.out.println("StepPass: Login successful");
		    }
		    	driver.findElement(By.className("oxd-userdropdown-img")).click();
		    	
		    	driver.findElement(By.xpath("//a[text()='Logout']")).click();
		    }
		    
		    
		    
		    Thread.sleep(3000);
		    
		    driver.navigate().refresh();
		    
		    Thread.sleep(3000);
		    
		    //for getting Screenshot we are using Base class method getScreenshot() here
		    
		  //  getScreenshot(driver);
		    
		    
		  //  System.out.println("Home Links text");
		    
		  //  for(WebElement temp: hrmH.getHomePageLinkElements()) {
		    	
		   // 	     System.out.println(temp.getText());
		   // }
		    
		    
		    
		}   
			
	Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void browserClosing() {
		
		driver.quit();
		
	} 

}
