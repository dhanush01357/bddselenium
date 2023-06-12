package cucumberframework.mp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;

public class scroll {
	
public static void main(String[] args) throws MalformedURLException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyM31");
	dc.setCapability(MobileCapabilityType.NO_RESET, true);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	dc.setCapability(MobileCapabilityType.NO_RESET,"true");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
	System.out.println("======================================");
	dc.setCapability(MobileCapabilityType.UDID, "RZ8NA27YLBB");
	dc.setCapability("appPackage", "com.google.android.youtube");
	dc.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
	URL url = new URL("http://localhost:4723/wd/hub");
	AndroidDriver<AndroidElement>driver=new AndroidDriver<AndroidElement>(url,dc);
	AndroidTouchAction action=new AndroidTouchAction(driver);
 //AndroidElement search = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"));
	//action.tap(ElementOption.element(search)).perform();
	By acto = MobileBy.xpath("(//android.widget.ImageView[@content-desc=\"Action menu\"])[2]/..");
	//.findElement(new Appium)
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("));
}
}
