package practicTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestUsingSendKey {

	public static void main(String[] args) {
		
        // Test Screept for Login Without Locketing second element 
		//and without clicking Only By passing Key lick  Tab,Enter.
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\SeleniumWebdriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement e=driver.findElement(By.id("txtUsername"));
		e.sendKeys("Admin");
		e.sendKeys(Keys.TAB+"admin123");
		e.sendKeys(Keys.TAB+""+Keys.TAB+""+Keys.ENTER);



	}

}
