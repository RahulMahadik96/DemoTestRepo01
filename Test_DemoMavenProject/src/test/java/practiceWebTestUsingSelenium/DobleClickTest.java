package practiceWebTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DobleClickTest {

	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\SeleniumWebdriver\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/buttons");
		WebElement doubleclickB=driver.findElement(By.id("doubleClickBtn"));
		
		Thread.sleep(3000);
		
		Actions action=new Actions(driver);
		
		action.doubleClick(doubleclickB).perform();
		
		boolean isdisplay=driver.findElement(By.id("doubleClickMessage")).isDisplayed();
		
		if(isdisplay==true) {
			System.out.println("Pass: We can Double click on the button ");
		}
		else {
			System.out.println("Fail: we are unable to Double click on the button");
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
