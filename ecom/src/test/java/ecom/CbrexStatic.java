package ecom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CbrexStatic {
	static WebDriver driver = null;

	public static int generateRandomNumber(int numberOfDigits) {
		Random random = new Random();
		int min = (int) Math.pow(10, numberOfDigits - 1);
		int max = (int) Math.pow(10, numberOfDigits) - 1;
		return random.nextInt(max - min + 1) + min;
	}

	public static String generateRandomAlphabets(int numberOfDigits) {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < numberOfDigits; i++) {
			char randomChar = (char) (random.nextInt(26) + 'A');
			stringBuilder.append(randomChar);
		}

		return stringBuilder.toString();
	}

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

		Thread.sleep(2000);
		List<WebElement> textfields = driver.findElements(By.tagName("input"));
		List<String> textfielsWithAttributeID = new ArrayList<String>();
//*****************************************************************************************************
		// for texfields
		
		
		
		for (WebElement element : textfields) {
			textfielsWithAttributeID.add(element.getAttribute("id"));
			System.out.println(element.getAttribute("id"));
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (String string : textfielsWithAttributeID) {
			try {
				
				switch (string) {
			    case "email":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys(generateRandomAlphabets(6)+"@gmail.com");			
					break;
			    case "additionalEmail":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys(generateRandomAlphabets(6)+"@gmail.com");			
					break;
			    case "mobile":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys("98882"+generateRandomNumber(5));			
					break;
			    case "additionalMobile":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys("98882"+generateRandomNumber(5));			
					break;
			    case "workExperience":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys(".9");			
					break;
			    case "relativeWorkExperience":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys(".9");			
					break;
			    case "currentSalary":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys("12");			
					break;
			    case "expectedSalary":
			    	driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys("15");			
					break;
				default:js.executeScript("document.getElementById('"+string+"').value = ''");						
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='" + string + "'and @value]")).sendKeys("aksjfdh");

					break;
				}
				
		       
			} catch (org.openqa.selenium.NoSuchElementException e) {

				System.out.println("//input[@id='" + string + "']");
			}
			catch (org.openqa.selenium.JavascriptException e) {

				System.out.println("//input[@id='" + string + "']");
			}
			
          driver.findElement(By.xpath("(//input[@type=\"file\"])[4]")).sendKeys("C:\\CBREX\\Candidate_Consent.pdf");
		}
	
		
//*****************************************************************************************************
// for radio button
		
		List <WebElement> radio=driver.findElements(By.xpath("//input[@type='checkbox']"));
				
		for (WebElement webElement : radio) {
			try {
				webElement.click();
			} catch (Exception e) {
				System.out.println(webElement.toString());
			}
		}
		
//*****************************************************************************************************
// for Select tag		

		List <WebElement> selecttag=driver.findElements(By.xpath("//select[not(@disabled)]"));
				
		for (WebElement webElement : selecttag) {
			try{
				Select select=new Select(webElement);
				select.selectByIndex(1);
			}
			catch (java.lang.UnsupportedOperationException e) {
				// TODO: handle exception
			}
		}
		
//*****************************************************************************************************
// for clicking on next 
		
		clickS("//span[text()='Next']");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Screening Questions']")));
		
		 boolean s=driver.findElement(By.xpath("//h3[text()='Screening Questions']")).isDisplayed();
		   System.out.println(s);
	}

}