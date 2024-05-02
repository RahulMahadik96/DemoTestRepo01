package practiceWebTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\SeleniumWebdriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClick=driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
		WebElement potion=driver.findElement(By.xpath("//span[normalize-space()='Quit']"));
		
		Actions action=new Actions(driver);
		
		action.contextClick(rightClick).perform();
		action.click(potion).perform();
		
		Alert alert=driver.switchTo().alert();
		
		String alertext=alert.getText();
		System.out.println(alertext);
		Thread.sleep(3000);
		alert.dismiss();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
