package feature;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	WebDriver driver;

    @Given("^Let me login as a guest user$")
    public void let_me_login_as_a_guest_user() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("http://omayo.blogspot.com/");
        
    }

    @When("^user enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_username_as_someusername_and_password_as_somepassword(String username , String password) {
    	repo r= new repo(driver);
		r.username.sendKeys(username);
    	
    	r.passwords.sendKeys(password);

    }
    
    @And("^click on login button$")
    public void click_on_login_button()  {
        driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
    }

    @Then("^user should get \"([^\"]*)\" result$")
    public void user_should_get_expected_result(String expectedResult)  {
    	String actualResult = null;
    	try {
    		Alert alert = driver.switchTo().alert();
    		if(alert.getText().equalsIgnoreCase("Error Password or Username")) {
    			actualResult = "Failure";
    		}
    	}
    	catch(Exception e) {
    		actualResult="Success";
    	}
        Assert.assertEquals(actualResult, expectedResult);
    }

 

}


