package practiceWebTestUsingSelenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUplodeHandelWithAutoIt {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tus.io/demo.html");
		WebElement fileUp=driver.findElement(By.id("js-file-input"));
		WebElement scroll=driver.findElement(By.id("instructions"));
		
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		
		Actions action=new Actions(driver);
		action.moveToElement(fileUp).click().perform();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Rahul\\AutoIt\\Autofil.exe");
		
		Thread.sleep(3000);
		driver.quit();

		
	}

}
