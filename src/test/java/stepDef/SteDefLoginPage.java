package stepDef;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SteDefLoginPage {
	WebDriver driver;
	
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver = WebDriverManager.chromedriver().create();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("inside Given");
	
	}
	
//	@When("User enters Login Credentials")
//	public void user_enters_login_credentials(){
//    	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//    	driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//    	driver.findElement(By.className("radius")).submit();
//    	System.out.println("inside When");
//    }
	

//	@When("User enters {string} and {string}")
//	public void user_enters_and(String strUserID, String strPswd) {
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strUserID);
//    	driver.findElement(By.id("password")).sendKeys(strPswd);
//    	driver.findElement(By.className("radius")).submit();
//    	System.out.println("inside When");
//	}


	@When("User enters Login Credentials")
	public void user_enters_and(DataTable dataTable) {
		//List<List<String>> userCreds= dataTable.asLists();
		List<Map<String, String>> userCreds = dataTable.asMaps();
		String strUserName, strPassword;
		strUserName = userCreds.get(0).get("username");
		strPassword = userCreds.get(0).get("password");
		System.out.println("username-password: "+strUserName+"-"+strPassword);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strUserName);
		driver.findElement(By.id("password")).sendKeys(strPassword);
		driver.findElement(By.className("radius")).submit();
		System.out.println("inside When");

	}


	
    @Then("User is able to navigate to Home Page")
    public void user_is_able_to_navigate_to_home_page(){
    	boolean isValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
    	Assert.assertTrue(isValid);
    	System.out.println("inside Then");
    }
	

}
