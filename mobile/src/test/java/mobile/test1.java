package mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;

public class test1 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M311");
	//	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.NO_RESET,"true");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		System.out.println("======================================");
		//dc.setCapability(MobileCapabilityType.UDID, "RZ8NA27YLBB");
		dc.setCapability("appPackage", "com.google.android.youtube");
		dc.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
	
		System.out.println("======================================");
	//	URL url = new URL("http://localhost:4723/wd/hub");
		//AndroidDriver<WebElement>driver=new AndroidDriver<WebElement>(url,dc);
		AndroidDriver<WebElement> driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),dc);
		AndroidTouchAction act=new AndroidTouchAction(driver);
	TouchActions action=new TouchActions(driver);
	Thread.sleep(10000);
		act.tap((TapOptions) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"))).perform();

	}

}