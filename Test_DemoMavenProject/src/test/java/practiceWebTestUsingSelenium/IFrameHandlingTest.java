package practiceWebTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandlingTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		    
		            //Single iframe Handling
		
		List<WebElement> list=driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		
		WebElement element=driver.findElement(By.id("singleframe"));
		driver.switchTo().frame(element);
		
		driver.findElement(By.xpath("//input")).sendKeys("Well come");
		
		list=driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		
		
		
		                 
		             //Nested iframe handling
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		element=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		
		driver.switchTo().frame(element);
		list=driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input")).sendKeys("Well come");
	
		Thread.sleep(3000);
		driver.quit();

	}

}
