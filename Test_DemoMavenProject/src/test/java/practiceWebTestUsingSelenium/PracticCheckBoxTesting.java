package practiceWebTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticCheckBoxTesting {

	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/Rahul/OneDrive/Documents/Rahul_doc1/PassimaticClass/SeleniumAutomation/Login.html");
		
		WebElement checkBox1=driver.findElement(By.name("agree"));
		boolean isSelected=checkBox1.isSelected();
		if(isSelected==false) {
			System.out.println("Pass: I agree checkbox is bydefauilt Not selected");
			
			WebElement checkBox2=driver.findElement(By.name("disagree"));
			isSelected=checkBox2.isSelected();
			if(isSelected==true) {
				System.out.println("Pass: I Disagree checkbox is Bydefauilt selected");
				
				checkBox1.click();
				isSelected=checkBox1.isSelected();
				if(isSelected==true) {
					System.out.println("Pass: I agree checkbox is selected after clicking");
					
					checkBox2.click();
					isSelected=checkBox2.isSelected();
					if(isSelected==false) {
						System.out.println("Pass: I Disagree CheckBox is not selected after clicking on I agree checkbox");
					
					  WebElement Disable=driver.findElement(By.xpath("//input[@name='disabledcheck']"));
					  boolean isEnable=Disable.isEnabled();
					  if(isEnable==false) {
						  System.out.println("Pass: Disable checkbox is bydefault disabled");
					  }
					  else {
						  System.out.println("Faill: Disable checkBox is Bydefault enable");
					  }
					}
				}
				else {
					System.out.println("Faill: I agree checkbox is not selected after clicking");
				}
				
			}
			else{
				System.out.println("Faill: I Disagree checkbox is Bydefauilt not selected");
			}
			
		}
		else {
			System.out.println("Faill: I agree checkbox is bydefauilt selected");
		}

	}

}
