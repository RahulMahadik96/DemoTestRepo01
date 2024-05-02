package practiceWebTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeRedioBottonTest {

	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/Rahul/OneDrive/Documents/Rahul_doc1/PassimaticClass/SeleniumAutomation/Login.html");
		
		WebElement redioBotton=driver.findElement(By.id("male"));
		boolean isSelect=redioBotton.isSelected();
		
		if(isSelect==true) {
			
			System.out.println("Pass: Male Redio botton is Bydefault selected");
		    WebElement redioBotton2=driver.findElement(By.id("female"));
		    isSelect=redioBotton2.isSelected();
		    
		    if(isSelect==false) {
		    	 System.out.println("Pass: Female Redio botton is Bydefault Not selected");
		    	 redioBotton2.click();
		    	
		    	 isSelect=redioBotton2.isSelected();
		    	 if(isSelect==true) {
		    		 System.out.println("Pass: Female Redio botton is selected After Clicking");
		    		 isSelect=redioBotton.isSelected();
		    		  
		    		 if(isSelect==false) {
		    			 System.out.println("Pass: Male Redio Botton is Not selected After clicking of the Female redio Botton");
		    		     
		    		 }
		    		 else {
		    			 System.out.println("Faill: Male Redio Botton is bydefault selected after clicking of the Female Redio Botton");
		    		 }
		    	 }
		    	 
		     }
		     else {
		    	 System.out.println("Faill: Female Redio botton is Bydefault Selected");
		     }
			
			
		}
		else {
			System.out.println("Faill: Male redio botton is not selected");
		}
		
		
		
	}

}
