package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base 
{
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException{
	   
	   String propertiesPath ="./src/main/java/resources/data.properties";
	   prop = new Properties();
	   FileInputStream fis = new FileInputStream(propertiesPath);
	   prop.load(fis);
	   
	   String browserName =prop.getProperty("browser");
	   
	   if(browserName.contains("chrome")){
		  
			 driver = new ChromeDriver();
			 System.out.println("This is Chrome browser");
	   }
	   else if(browserName.contains("firefox")){
		   	   
		   driver = new FirefoxDriver();
		   System.out.println("This is firefox browser");
	   }
	   else if(browserName.contains("edge")){
		   
		   driver = new EdgeDriver();
		   System.out.println("This is edge browser");
	   }
	   else {
		   System.out.println("Invalid browser, please specify correct browser name in the properties file");
	   }
	   driver.manage().window().maximize();
	   System.out.println("Windows Maximized");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   System.out.println("Implicit wait set as 10 seconds");
	   System.out.println("Successfully initialized driver, browser launched successfully");
	   return driver;
	}
	
	
	
	public String getScreenshot( WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = "./Screenshots/screenshot.png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}
	
	
	
}

