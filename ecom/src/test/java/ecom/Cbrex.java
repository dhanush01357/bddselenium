package ecom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cbrex {
	static WebDriver driver = null;

	public static void clickS(String xpath) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void enters(String xpath, String input) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://next.cbr.exchange/");

		clickS("//nav[@class=\"main-nav float-right d-none d-lg-block\"]//a[contains(text(),'Login')]");
		clickS("//div[@class=\"dropdown-menu show\"]//a[text()='Employer']");
		enters("//input[@name=\"email\"]", "rajnikashvi11@gmail.com");
		enters("//input[@name=\"password\"]", "Cbrex1234");
		clickS("//button[@type=\"submit\"]");

		Thread.sleep(3000);

		driver.get("https://next.cbr.exchange/app/supplier/uploadresume?jobId=17780");

		Thread.sleep(3000);
		enters("//input[@type=\"file\"]", "C:\\CBREX\\20230226_060402Class_5_Mathematics.pdf");

		clickS("//span[text()='Parse Resume']/parent::button[not(@disabled)]");

		clickS("//span[text()='Proceed']");
		Thread.sleep(10000);

		List<WebElement> textfields = driver.findElements(By.tagName("input"));
		List<String> textfielsWithAttributeID = new ArrayList<String>();

		for (WebElement element : textfields) {
			textfielsWithAttributeID.add(element.getAttribute("id"));
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (String string : textfielsWithAttributeID) {
			try {

				js.executeScript("arguments[0].value = '';",
						driver.findElement(By.xpath("//input[@id='" + string + "']")));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys("aksjfdh");

			} catch (org.openqa.selenium.NoSuchElementException e) {

				System.out.println("//input[@id='" + string + "']");
			}
		}

	}

}