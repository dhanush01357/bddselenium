package ecom;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switchbettweendiffrenttab {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(opt);
		
		//WebDriverManager.chromedriver().setup();
	//	driver=new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src=\"https://rukminim1.flixcart.com/fk-p-flap/240/240/image/907c0aa66a4343e9.jpg?q=90\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//img[@loading=\"eager\"]")).click();
		String pwindow = driver.getWindowHandle();
		System.out.println(pwindow);
	Set<String> cwindow = driver.getWindowHandles();
	System.out.println(cwindow);
	for (String dd : cwindow) {
		if (!dd.equals(pwindow)) {
			driver.switchTo().window(dd);
			Thread.sleep(10000);
			Actions a=new Actions(driver);
		WebElement abcd = driver.findElement(By.xpath("//img[@loading=\"eager\"]"));
	a.moveToElement(abcd).build().perform();
		Robot rob=new Robot();
		//	rob
			
//driver.findElement(By.xpath("//img[@loading=\"eager\"]")).
			//driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		}
		
	}
	}

}
