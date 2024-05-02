package practiceWebTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticDropDownTest {

	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='day']"));
		
		Select day=new Select(dropdown);
		
		List<WebElement> options=day.getOptions();
		
		for(WebElement tempE:options) {
			System.out.print(tempE.getText());
			System.out.print(" ");
		}
		day.selectByIndex(5);
		Thread.sleep(3000);
		day.selectByValue("10");
		Thread.sleep(3000);
		day.selectByVisibleText("9");
		Thread.sleep(5000);
		 
		
		
		
		dropdown=driver.findElement(By.cssSelector("#month"));
		Select month=new Select(dropdown); 
		List<WebElement> me=month.getOptions();
		System.out.println("");
		System.out.println("Month Option available");
		for(WebElement tm:me) {
			System.out.print(tm.getText());
			System.out.print(" ");
		}
		
		System.out.println("");
		month.selectByIndex(4);
		month.selectByVisibleText("Oct");
		month.selectByValue("6");
		
		boolean isMultipleselected=month.isMultiple();
		System.out.println("the given element is multiple selecter: "+isMultipleselected);
		
		
		
		

	}

}
