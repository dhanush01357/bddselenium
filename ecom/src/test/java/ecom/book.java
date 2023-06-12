package ecom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class book {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// WebDriverManager.chromedriver().setup();
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();

		// WebDriver d=new ChromeDriver(o);
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.get("https://dev1.cbr.exchange/");
		driver.findElement(By.xpath("//a[@role=\"button\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Employer']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"email\"]"))));
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("rajnikashvi11@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Cbrex1234");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//aside//div[@class=\"w-fit\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Jobs\"]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()=\"Upload Resume\"]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//span[text()=\"Upload Resume\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"file\"]"))
				.sendKeys("C:\\CBREX\\20230226_060402Class_5_Mathematics.pdf");
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//div[@class=\"flex justify-end space-x-2 pt-1\"]/..//span[text()=\"Parse Resume\"]"))
				.click();
		driver.findElement(By.xpath("//div[@class=\"flex justify-end space-x-2 pt-1\"]/..//span[text()=\"Proceed\"]"))
				.click();
		List<WebElement> allelementoftextfield = driver.findElements(By.tagName("input"));
		List<String> allelementoftextfieldtext = new ArrayList<String>();
		for (WebElement webElement : allelementoftextfield) {
			allelementoftextfieldtext.add(webElement.getAttribute("id"));

		}

		for (String string : allelementoftextfieldtext) {
			driver.findElement(By.xpath("//input[@id='"+string+"']")).sendKeys("abcdef");
			File file =new File("C:\\Users\\Dhanush S\\Desktop\\Search.xlsx");
			FileInputStream fis=new FileInputStream(file);
			
Workbook work=WorkbookFactory.create(file);
Sheet sheet =work.getSheet("Sheet1");
for(int j=0; j<sheet.getLastRowNum(); j++) 
{
	FileOutputStream fos=new FileOutputStream(file);
	sheet.getRow(0).getCell(0).setCellValue(string);
	work.write(fos);
	work.close();
	fos.close();
	fis.close();
}
			System.out.println(string);
		}
	}

}
