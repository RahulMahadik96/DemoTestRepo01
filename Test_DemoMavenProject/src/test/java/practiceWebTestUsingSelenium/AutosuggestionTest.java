package practiceWebTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestionTest {

	public static void main(String[] args) throws InterruptedException {
		
		              //Handling AutoSuggetion on the Google Search 
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
			 
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");

        List<WebElement> list=driver.findElements(By.xpath("//li//span[text()='selenium']"));
		System.out.println("Autosugetions are: ");
		for(WebElement aselement:list) {
		         System.out.print(aselement.getText());
	    }
		for(WebElement Autosuggetion:list) {
			if(Autosuggetion.getText().contains("selenium webdriver")) {
				Autosuggetion.click();
				break;
				
			}
		}
		
		Thread.sleep(5000);
		driver.quit();

	}

}
