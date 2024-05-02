package practiceWebTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class KeyBordEvent_SendKeytest {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("userName")).sendKeys("RAHUL MAHADIK");
		driver.findElement(By.id("userEmail")).sendKeys("rahul.mahadik96@gmail.com");
		
		WebElement caddrass=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		
		//WebElement paddrass=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		
		
		caddrass.sendKeys(" SHEGAON, SANGLI, Maharashtra-416404 ");
		 
		
		//caddrass.sendKeys(Keys.CONTROL+"A"+"C");
		
		//caddrass.sendKeys(Keys.TAB+""+Keys.CONTROL+"V");
		
		Thread.sleep(3000);

		Actions action=new Actions(driver);
		
		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").perform();

		Thread.sleep(3000);
		driver.quit();



	}

}
