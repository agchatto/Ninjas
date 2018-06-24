package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagefactory.AccountPage;
import utility.CommerceHook;

public class LogOutStepDef {
	private WebDriver chromeDriver = CommerceHook.getChromeDriver();
	private WebDriver firefoxDriver = CommerceHook.getFireFoxDriver();
	AccountPage chrome = new AccountPage(chromeDriver);
	AccountPage fire = new AccountPage(firefoxDriver);
	
	@Given("^User Arrives to Login Page$")
	public void user_Arrives_to_Login_Page() throws Throwable {
		//https://demo.oscommerce.com/login.php
		String baseUrl = "https://demo.oscommerce.com/login.php";
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.get(baseUrl);
		
		firefoxDriver.manage().window().maximize();
		firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firefoxDriver.get(baseUrl);
	   
	}

	@When("^User Enters Valid Credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Enters_Valid_Credentials_and(String email, String password) throws Throwable {
		chrome.emailId().sendKeys(email);
		chrome.password().sendKeys(password);
		chrome.signInBtn().click();
	    
		fire.emailId().sendKeys(email);
		fire.password().sendKeys(password);
		fire.signInBtn().click();
	   
	}

	@Then("^User Arrives to Account Page$")
	public void user_Arrives_to_Account_Page() throws Throwable {
		String actual = chromeDriver.getCurrentUrl();
		Assert.assertEquals(actual, "https://demo.oscommerce.com/index.php");
		
		String actual2 = firefoxDriver.getCurrentUrl();
		Assert.assertEquals(actual2, "https://demo.oscommerce.com/index.php");
	   
	   
	}

	@Then("^User Successfully Logoff$")
	public void user_Successfully_Logoff() throws Throwable {
		chrome.signOutBtn().click();
		String logOut = chromeDriver.getCurrentUrl();
		Assert.assertEquals(logOut, "https://demo.oscommerce.com/logoff.php");
		
		fire.signOutBtn().click();
		String logOut2 = firefoxDriver.getCurrentUrl();
		Assert.assertEquals(logOut2, "https://demo.oscommerce.com/logoff.php");
	  
	}

}
