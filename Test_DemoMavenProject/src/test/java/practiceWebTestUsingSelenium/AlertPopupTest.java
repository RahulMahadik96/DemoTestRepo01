package practiceWebTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertPopupTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\SeleniumWebdriver\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");
		
		             //Simple Alert Test
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		Alert alert=driver.switchTo().alert();	
	    System.out.println("Simple Alert text: "+alert.getText());
	    Thread.sleep(3000);
	    alert.accept();
	    Thread.sleep(3000);
	              
	                 // Confirmation Alert Test
	    driver.findElement(By.id("confirmButton")).click();
	    
	    alert=driver.switchTo().alert();
	    System.out.println("Confirmation Alert text: "+alert.getText());
	    Thread.sleep(3000);
	    alert.dismiss();
	    
	    String confirmationText = driver.findElement(By.id("confirmResult")).getText();
	    if(confirmationText.contains("Cancel"))
	    	System.out.println("Pass: Confirmation Alert Handled");
	    else
	    	System.out.println("Fail: Confirmation Alert Not Handled");
	    
	    Thread.sleep(3000);
	    
	           //Promt Alert Test
	    driver.findElement(By.id("promtButton")).click();
	    alert=driver.switchTo().alert(); 
	    
	    alert.sendKeys("Rahul Mahadik");
	    alert.accept();
	    String resultText=driver.findElement(By.id("promptResult")).getText();
	    if(resultText.contains("Rahul"))  
	    	System.out.println("Pass: Promt Alert Handled");
	    else
	    	System.out.println("Fail: Promt Alert Not Handled");
	    
	    Thread.sleep(3000);
	    driver.quit();
		
	}

}
