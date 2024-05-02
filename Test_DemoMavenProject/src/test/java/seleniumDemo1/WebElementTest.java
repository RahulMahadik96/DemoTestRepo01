package seleniumDemo1;

import java.net.SocketException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebElementTest {
	
	// In this programe we are going to test the 
	//1)lounch the chrome browser
	//2) Enter the input on browser and 
	//3) submit the things Using the selenium WebDriver

	public static void main(String[] args) throws InterruptedException,SocketException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.facebook.com/"); //here  get url.
		
		System.out.println(driver.getTitle());    // here get title
	
		driver.findElement(By.id("email")).sendKeys("7758972804"); // here find and send data to the element
		
		driver.findElement(By.id("pass")).sendKeys("1394");
		
		WebElement we=driver.findElement(By.name("login"));
		
		System.out.println(" the Login is enabled: "+we.isEnabled()); //checking the give element isEnable or not
	
		System.out.println("The Atributes of butten: "+we.getAttribute("login"));
		
		we.click();                                            // here we cliching the butten
		
		//System.out.println("the login is selected: "+we.isSelected());
		
		 
		Thread.sleep(5000);
		
		driver.navigate().back();      // here we navigate the back
		Thread.sleep(5000);
		
		
		
		driver.navigate().forward();     //here we navigate the forward
		Thread.sleep(5000);
		
		
		
		driver.findElement(By.id("email")).clear();   // here we clear the things which we have sended beforr
		driver.findElement(By.id("pass")).clear();
		
		
		
		driver.findElement(By.id("email")).sendKeys("7758972804");
		
		driver.findElement(By.id("pass")).sendKeys("rahul@1996");
		
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@role='banner']//descendant::input[@aria-label='Search Facebook']")).sendKeys("Rahul");
		 
		//driver.findElement(By.xpath("//div[@aria-label='खाते']")).click();
		 
		//driver.findElement(By.xpath("//span[contains(normalize-space(),'लॉग आउट')]")).click();
	    
		
		
		//driver.close();           // here we close the given parent browser 
		
		System.out.println("   Succesfuly tested All the things");
		
		
		
		// This programe is successfuly executed.
		
	
	}

}
