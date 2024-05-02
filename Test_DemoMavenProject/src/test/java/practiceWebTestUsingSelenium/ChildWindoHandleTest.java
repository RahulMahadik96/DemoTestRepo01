package practiceWebTestUsingSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ChildWindoHandleTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\SeleniumWebdriver\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		WebElement login=driver.findElement(By.xpath("//div[normalize-space()='Login']"));
	     login.click();
	     String text=login.getText();
         if(text.contains("Login")) {
        	 System.out.println("Pass: we are on the Login Popup");
         }
         
         driver.findElement(By.xpath("//span[normalize-space()='Sign in with Google']")).click();
         
         
         Set<String> windowes=driver.getWindowHandles();
         
         for(String handles:windowes) {
        	 driver.switchTo().window(handles);
        	String cwtitle=driver.getTitle();
        	 if(cwtitle.contains("Google accounts")) {
        		 break;
        	 }
         }
         
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Welcome Rahul");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
