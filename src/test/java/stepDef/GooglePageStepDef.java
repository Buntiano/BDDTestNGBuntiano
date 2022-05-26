package stepDef;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageStepDef {
	WebDriver driver;


	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver = WebDriverManager.chromedriver().create();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("inside Given");
	
	}
	
	@When("User Searches for Java Tutorial")
	public void user_searches_for_java_tutorial() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		System.out.println("inside When before search");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Java Tutorial");
		searchbox.submit();
		System.out.println("inside When after Submit");
	
	}
	
	@Then("Should diplay Java Restult Page")
	public void should_diplay_java_restult_page() {
	    // Write code here that turns the phrase above into concrete actions
		String strTitle = driver.getTitle();
		org.testng.Assert.assertEquals("Java Tutorial - Google Search", strTitle);
		System.out.println("inside Then");
	    
	}

	//Python Search Glue
	@When("User Searches for Python Tutorial")
	public void user_searches_for_python_tutorial() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		System.out.println("inside When before search");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Python Tutorial");
		searchbox.submit();
		System.out.println("inside When after Submit");
	
	}
	
	@Then("Should diplay Python Restult Page")
	public void should_diplay_python_restult_page() {
	    // Write code here that turns the phrase above into concrete actions
		String strTitle = driver.getTitle();
		org.testng.Assert.assertEquals("Python Tutorial - Google Search", strTitle);
		System.out.println("inside Then");
	    
	}
	
	@After
	public void f_FailedScreenshot(Scenario scenario) throws IOException{
		if(scenario.isFailed()){
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			byte[] imgByte = FileUtils.readFileToByteArray(src);
			scenario.attach(imgByte, "image/png", "image1");
			
		}
		
	}



}
