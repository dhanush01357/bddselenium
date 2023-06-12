package tTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class t2Test {
	WebDriver driver;

	@Test
	public void test1() throws AWTException {

		// driver=new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		// WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("bat");
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-base\"]/..//div")).click();
		String element1 = driver.getWindowHandle();
		Set<String> elemnt2 = driver.getWindowHandles();
		for (String finale : elemnt2) {
			if (!finale.equals(element1)) {
				driver.switchTo().window(finale);
				WebElement cart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"))));
				// JavascriptExecutor js= (JavascriptExecutor)driver;
				// js.executeScript(null, null)
				// h2[contains(text(),'Get instant recommendations')]
				Actions action = new Actions(driver);

				action.moveToElement(
						driver.findElement(By.xpath("//a[text()='Sell on Amazon']"))).perform();
				driver.findElement(By.xpath("//a[text()='Sell on Amazon']")).isDisplayed();

		//	driver.findElement(By.xpath("//div[@class=\"a-image-container a-dynamic-image-container shopbylook-btf-image-container\"]/../../../../..//input")).click();
			
			driver.quit();
			}

		}

	}

}
