package xpathExamples;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathsForHRM {

	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		                         //TestCase No:1 launch OrangeHRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String title=driver.getTitle();
		System.out.println("title: "+title);
		
		                        //TestCase No:2 Verify App Launched Successfully
		if(title.equalsIgnoreCase("OrangeHRM")==true) {
			
			                    //TestCase No:3,4,5 Enter user name, password and login  
			driver.findElement(By.xpath("//input[@id='txtUsername' or  @name='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='txtPassword' or  @type='password']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@id='btnLogin' and  @value='LOGIN']")).click();
			
			                   //TestCase No:6 Verify login is Successful using Xpath with 'contains'
			boolean displayed=driver.findElement(By.xpath("//img[contains(@src,'themes/custom/images/logo.png')]")).isDisplayed();
			if(displayed==true) {
			   System.out.println("Logo is Displayed case is Successful");	
			}
			else {
			   System.out.println("Faild: We are going to wrong");
			}
			
			                 //TestCase No:7 Verify login is Successful using Xpath with 'start-with'
			displayed=driver.findElement(By.xpath("//img[starts-with(@alt,'OrangeHRM')]")).isDisplayed();
			if(displayed==true) {
				System.out.println("The image is Displayed case is Successful ");
			}
			else {
				System.out.println("Faild: image is Not Displayed");
			}
			
			
			                //TestCase No:8 Verify login is Successful using Xpath with Chained-Xpath
			displayed=driver.findElement(By.xpath("//div[@id='branding']/a[@target='_blank']/img[@alt='OrangeHRM']")).isDisplayed();
			if(displayed==true) {
				System.out.println("Case No:8 successful we are on correct page");
			}
			else {
				System.out.println("Case No:8 faild");
			}
			
			
			driver.findElement(By.xpath("//b[contains(normalize-space(),'Dashboard')]")).click();
			
			               //TestCase No:9 verify Pending Leave Requests option is visible using Xpath with text()
			boolean enable=driver.findElement(By.xpath("//legend[contains(text(),'Pending Leave Requests')]")).isEnabled();
			if(enable==true) {
				System.out.println("Pending Leave Requsts is Enable");
			}
			else {
				System.out.println("Faild: Pending Leave Requsts is disable");
			}
			
			
		}
		else {
			System.out.println("Failed:Unable to Launch");
		}
		  
		
	 driver.quit();
	 
	 System.out.println("Test Cases Successful");
		

	}

}
