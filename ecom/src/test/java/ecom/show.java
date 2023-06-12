package ecom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

public class show {
	public static void main(String[] args) {
		
		/*
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();

		// WebDriver d=new ChromeDriver(o);
		WebDriver driver = new ChromeDriver(o);
		driver.get("https://in.bookmyshow.com/");
driver.manage().window().maximize();
WebElement banglore = driver.findElement(By.xpath("//img[@alt=\"BANG\"]"));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(banglore));
banglore.click();
Scanner sc=new Scanner(System.in);
sc.next();
driver.findElement(By.xpath("//a[contains(@id,"+sc+")]")).click();
*/

List  t=new ArrayList<>();
t.add("hgjhg");
t.add("hhu");
t.add(true);

System.out.println(t);
for (int i = 0; i < t.size(); i++) {
	System.out.println(t.get(i));
}
	}
}
