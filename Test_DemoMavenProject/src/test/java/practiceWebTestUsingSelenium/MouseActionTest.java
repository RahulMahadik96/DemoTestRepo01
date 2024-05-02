package practiceWebTestUsingSelenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionTest {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement fmove=driver.findElement(By.xpath("//b[normalize-space()='Admin']"));
		WebElement smove=driver.findElement(By.xpath("//a[normalize-space()='Job']"));
		WebElement fclick=driver.findElement(By.xpath("//a[normalize-space()='Work Shifts']"));
		Actions action=new Actions(driver);
		
		//action.moveToElement(fmove).moveToElement(smove).moveToElement(fclick).click().perform();
		
		
		  action.moveToElement(fmove).perform();
		  Thread.sleep(3000);
		  action.moveToElement(smove).perform();
		  Thread.sleep(3000);
		  action.moveToElement(fclick).click().perform();
		  
		 Thread.sleep(3000);
		driver.quit();
		
		

	}

}
