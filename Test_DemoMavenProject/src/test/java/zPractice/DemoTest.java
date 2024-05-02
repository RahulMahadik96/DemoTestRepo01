package zPractice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonLibraries.ExcelLibrary;


public class DemoTest {
	
	ExcelLibrary xlLibrary;
	
	@BeforeSuite
	public void beforeSuiteConfg() {
		
		 System.out.println("Before Sute Annotation");
	} 
	
	@BeforeTest
	public void beforeTestConfg() {
		System.out.println("Before Test Annotation");
	}
	
	@ BeforeClass
	public void beforeClassConfig() throws EncryptedDocumentException, IOException {
		   xlLibrary=new ExcelLibrary();
		   xlLibrary.LoadAllExcelData();
		   xlLibrary.LoadExcelData();
		
		    System.out.println(" Before Class Annotation ");
	}
	
	@BeforeMethod
	public void beforeMethodConfig() {
		System.out.println(" Before Method Annotation ");
	} 
	
	@Test
	public void firstTestNGTest() {
		
		 //WebDriver driver = new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.manage().window().maximize();
		//	driver.get("https://opensource-demo.orangehrmlive.com/");
			
			System.out.println("TestFirst: Web app successfully launched ");
			
			//driver.quit();
			
		    System.out.println("List of UserNames & Passwordsfrom Excel");
		    
		    System.out.println("UserName: "+ xlLibrary.getUsername());
		    System.out.println("Password: "+ xlLibrary.getPassword());
		    
		    System.out.println("UserNames: ");
			
			for(String temp: xlLibrary.getUnames()) {
				System.out.println(temp);
				
			}
			
			System.out.println();
			System.out.println("Passwords: ");
			
			for(String temp: xlLibrary.getPwords()) {
				
				System.out.println(temp);
			}
			
			
			
			
		
	}
	
	
	@Test
	public void sencondTestNGTest() {
		
		System.out.println("This my 2nd TestNg Test");
	}
	
	@AfterMethod
	public void afterMethodConfig() {
		
		System.out.println("After Method Annotations");
	} 
	
	
	
	@AfterTest
	public void afterTestConfig() {
		System.out.println("After Test Annotation ");
	}
	
	
	@AfterSuite
	public void afterSuiteConfig() {
		
		 System.out.println("After Suite annotation");
	}
	
	@ AfterClass
	public void afterClassConfig() {
		
		System.out.println("After Class annotoation ");
	} 
	
	

}
