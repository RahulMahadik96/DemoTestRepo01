package androidTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidCalculaterTest {
	
	
	public static void main(String args[]) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName", "OnePlus Nord CE 2");
		cap.setCapability("udid", "VSR8BARKYLHMIZGA");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		
		cap.setCapability("appPackage", "com.oneplus.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		// AppiumDriver driver=new AppiumDriver(url, cap);
		 
		System.out.println("Application Started");

	}

}
