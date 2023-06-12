package cucumberframework.poiclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellReferenceType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class script {
	static WebDriver driver;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		String filepath = "C:\\Users\\Dhanush S\\Desktop\\Book12.xlsx";
		File file = new File(filepath);
		FileInputStream ips = new FileInputStream(file);
		Workbook work = WorkbookFactory.create(ips);
		String sheetname = work.getSheetName(0);
		CellReferenceType ref = work.getCellReferenceType();
		System.out.println(sheetname);
		System.out.println(ref);
		Sheet sheet=work.getSheet(sheetname);
		int pp = sheet.getPhysicalNumberOfRows();
		CellRangeAddress rr = sheet.getRepeatingColumns();
		System.out.println(rr);
		System.out.println(pp);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			
			
	//	Cell cellnum = sheet.getRow(2).getCell(0);
	//	System.out.println(cellnum);
		String sheellvalue = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println(sheellvalue);
	//	
		
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(sheellvalue);
		for (int j = i; j <=i; j++) {
			String password = sheet.getRow(j).getCell(1).getStringCellValue();
			System.out.println(password);
		driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"pass\"]")).clear();
	}}
		FileOutputStream ops=new FileOutputStream(file);
		  sheet.getRow(1).getCell(0).setCellValue("naveen");
		work.write(ops);
		work.close();
		ops.close();
		
		ips.close();
		//System.out.println(op);
		driver.quit();
	}

}


