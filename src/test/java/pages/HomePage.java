package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccLink;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		//you can do this without pagefactory 
	}
	
	
	//Page Actions
	
	//Navigate to Login Page
	public void navigateToLogin(){
		myAccLink.click();
		loginLink.click();
	}
	

}
