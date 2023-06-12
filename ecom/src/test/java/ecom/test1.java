package ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class test1 {
	public static void main (String[] args) throws AWTException
	{
		 

		
		//WebDriverManager.chromedriver().setup();
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--remote-allow-origins=*");
		o.addArguments("−−incognito");
        DesiredCapabilities cap= new DesiredCapabilities();
    String e=    cap.getBrowserName();
    System.out.println(e);
        cap.setCapability(ChromeOptions.CAPABILITY,o);
	    WebDriver d= new ChromeDriver(o);
	    d.manage().window().maximize();
	    d.get("https://www.amazon.com");
	    d.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("mobile");
	    Robot a=new Robot();
	    a.keyPress(KeyEvent.VK_ENTER);
	    a.keyRelease(KeyEvent.VK_ENTER);
	    
	    
}
}
