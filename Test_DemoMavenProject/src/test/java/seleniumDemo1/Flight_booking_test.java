package seleniumDemo1;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flight_booking_test {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://www.goibibo.com/");
		
		WebElement oneWay=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='One-way']/preceding-sibling::span"))); 
		
		boolean isSelected=oneWay.isSelected();
		if(isSelected) {
			System.out.println("StepPass: One-way is Bydefoult Selected");
			isSelected=driver.findElement(By.xpath("//span[normalize-space()='Round-trip']")).isSelected();
			if(isSelected==false) {
				System.out.println("StepPass: Round-Trip is Bydefoult UnSelected ");
			}
			else {
				System.out.println("StapFail: Round-Trip is Bydefoult Selected");
			}
		}
		else {
			System.out.println("One-way is Bydefoult Not Selected");
			WebElement roundTrip= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Round-trip']/preceding-sibling::span")));
					roundTrip.click();
			isSelected=driver.findElement(By.xpath("//span[normalize-space()='Round-trip']")).isSelected();
			if (isSelected) {
				System.out.println("StepPass:One-way is Bydefoult not selected but Round-trip is Bydefoult selected");
			}
			else {
				System.out.println("StepFail: One-Way and Round-Trip both are Bydefoult not selected ");
			}
		}
		
		driver.quit();
		
	}

}
