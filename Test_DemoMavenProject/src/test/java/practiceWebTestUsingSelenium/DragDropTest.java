package practiceWebTestUsingSelenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\SeleniumWebdriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://selenium08.blogspot.com/2020/01/drag-me.html");
		
		WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropArea=driver.findElement(By.xpath("//h3[normalize-space()='Drag me']"));
		
		Actions action=new Actions(driver);
		String beforS=draggable.getAttribute("style");
		 
		
		  Thread.sleep(3000);
		  action.clickAndHold(draggable).build().perform();
		  action.moveByOffset(100, 100).perform();
		  action.release().perform();
		 
			 
			  String afterS=draggable.getAttribute("style");
		
		 if(beforS.contains(afterS)==false) {
			 System.out.println("Pass: Draged and Draoped Successful");
		 }
		 else {
			 System.out.println("Fail: didn't dragged and dropped ");
		 }
		 
		 
		 Thread.sleep(3000);
		  action.clickAndHold(draggable).build().perform();
		  action.moveByOffset(-100, -100).perform();
		  action.release().perform();
		 
		 Thread.sleep(3000);
		 action.dragAndDrop(draggable, dropArea);
		 
		 Thread.sleep(3000);
		 driver.quit();

	}

}
