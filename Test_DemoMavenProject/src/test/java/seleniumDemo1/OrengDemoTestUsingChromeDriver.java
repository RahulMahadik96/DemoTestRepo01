package seleniumDemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrengDemoTestUsingChromeDriver {

	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
	    By by=By.id("txtUsername");
		WebElement element=driver.findElement(by);
		element.clear();
		element.sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.id("calFromDate")).click();
		driver.findElement(By.className("ui-datepicker-month")).click();
		driver.findElement(By.linkText("17")).click();
		driver.findElement(By.xpath("//b[normalize-space()='My Info']")).click();
		
		boolean isSelected=driver.findElement(By.id("personal_optGender_1")).isSelected();
		if(isSelected) {
			System.out.println("StepPass: user is Male, Male is Selected");
			isSelected=driver.findElement(By.xpath("//label[normalize-space()='Female']")).isSelected();
			if(isSelected==false) {
				System.out.println("StepPass: User is female, Female is Selected ");
			}
			else {
				System.out.println("StapFail: male and Female bothe are selected ");
			}
		}
		else {
			System.out.println("User is Female, male is not selected");
			isSelected=driver.findElement(By.xpath("//label[normalize-space()='Female']")).isSelected();
			if (isSelected) {
				System.out.println("StepPass: User is Female, Male is not selected Female is selected");
			}
			else {
				System.out.println("StepFail: Male and Female both are not selected ");
			}
		}
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		
	    //driver.findElement(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a")).click();
		             
		
		//Thread.sleep(5000);  
		//driver.quit();
		
		
		
		
	}

}
