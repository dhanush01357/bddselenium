package cucumberframework.mp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;



public class mobtest1 {


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
		//By acto = MobileBy.xpath("(//android.widget.ImageView[@content-desc=\"Action menu\"])[2]/..");
		//.findElement(new Appium)
		WebDriverWait wait =new WebDriverWait(driver, 20);
		int maxSwipe=5;
		int swipeCount = 0;
		
		while(maxSwipe>swipeCount)
		try {
			
			WebElement ele=driver.findElement(By.xpath("sd"));
			if(ele.isDisplayed()==true) {
				ele.click();
				break;
			}
			
		}catch(NoSuchElementException e) {
			swipe(driver);
			swipeCount++;
		}
		





	}
	public static void swipe(AndroidDriver<AndroidElement> driver) {

		Dimension size = driver.manage().window().getSize();
		int startX = (int) (size.width * 0.5);
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.2);

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(startX, endY))
		.release()
		.perform();
		System.out.println("swiped");
		



	}
}


/*AndroidElement i=aa.findElement(By.id("com.whatsapp:id/menuitem_search"));
t.tap(ElementOption.element(i)).perform();*/


