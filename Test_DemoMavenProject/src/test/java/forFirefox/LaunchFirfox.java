package forFirefox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchFirfox {

	public static void main(String[] args) throws InterruptedException {
		
		                //Find element by using the Absolute XPath.
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\SeleniumWebdriver\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/in/login");
		By by=By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/form/div[2]/input");
		WebElement element=driver.findElement(by);
		element.clear();
		element.sendKeys("Admin"); 
		
		WebElement e=driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/form/div[3]/input"));
		e.clear();
		e.sendKeys("admin123");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/form/div[5]/input")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a")).click();
		Thread.sleep(5000);
		driver.quit(); 
		System.out.println("-----------------------------------------------");
		System.out.println("         Test Script Successfully work"); 
		

	}

}
