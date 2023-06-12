package Cpack;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {
	//WebDriver driver;
	public static void main(String[] args) {
		WebDriver driver;
	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='✕']")).click();
		String titleofflipkart = driver.getTitle();
		System.out.println(titleofflipkart);
	String pagssource = driver.getPageSource();
		System.out.println(pagssource);
		Scanner sc=new Scanner(System.in);
		String tags = sc.nextLine();
		
		List<WebElement> tagOfA = driver.findElements(By.tagName(tags));
		for (WebElement kg : tagOfA) {
			if ( kg.getText().length()>0) {
				System.out.println(kg);
				String namesOfATag = kg.getText();
				System.out.println(namesOfATag);

				
			}
			
		}
		
		
		
		
		
		for (int i = 0; i < tagOfA.size(); i++) {
			if (tagOfA.get(i).getText().length()>0) {
				
			
		String namesOfATag = tagOfA.get(i).getText();
		Point namesOfATags = tagOfA.get(i).getLocation();
			System.out.println(namesOfATag);
			System.out.println(namesOfATags);
			}
		}
		
	}

}
