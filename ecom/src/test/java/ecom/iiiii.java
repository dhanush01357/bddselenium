package ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iiiii {public static void main(String[] args) {
	ChromeOptions o=new ChromeOptions();
	o.addArguments("--remote-allow-origins=*");
//	WebDriverManager.chromedriver().setup();
	
	WebDriver d=new ChromeDriver(o);
	d.manage().window().maximize();
}
}