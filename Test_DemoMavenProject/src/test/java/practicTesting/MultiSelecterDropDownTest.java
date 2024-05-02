package practicTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelecterDropDownTest {

	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");

		WebElement multiSelecter=driver.findElement(By.xpath("//select[@name='selenium_commands']"));
		Select select=new Select(multiSelecter);
		
		List<WebElement> list=select.getOptions();
		List<String> text=new ArrayList<>(); 
		
		for(WebElement temE:list) {
			
			text.add(temE.getText());
		 }
		
		for(String temT:text) {
			System.out.println(temT);
		}
		System.out.println("");
		System.out.println("Drop-Down is Multiselecter: "+select.isMultiple());
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", multiSelecter);
		
		select.selectByIndex(1);
		select.selectByIndex(2);
		
		Thread.sleep(2000);
		
		select.deselectAll();
		
		for(WebElement temE:list) {
			temE.click();
		}
		
		select.deselectAll();
		Thread.sleep(3000);
		list=select.getOptions();
		for(WebElement te:list) {
			select.selectByVisibleText(te.getText());
		}
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
