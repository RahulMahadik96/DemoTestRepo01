package practiceWebTestUsingSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NewPagePopupTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Help center']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		 
		for(String thandles:handles) {
			driver.switchTo().window(thandles);
			String title=driver.getTitle();
			if(title.contains("Frequently Asked")==true) {
				System.out.println("Pass: Selenium Focuse on new child page");
				break;
			}
		}
		
		driver.findElement(By.id("keyword_search")).sendKeys("New Jobs");
		driver.findElement(By.className("search_btn")).click();
		
		driver.findElement(By.xpath("//img[contains(@src,'808_icon-8.png')]")).click();
		
		WebElement element=driver.findElement(By.xpath("//h2[@id='103']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println("Successfully Tested");
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}
