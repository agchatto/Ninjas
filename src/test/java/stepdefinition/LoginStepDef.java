package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagefactory.AccountPage;
import utility.CommerceHook;

public class LoginStepDef {
	private WebDriver chromeDriver = CommerceHook.getChromeDriver();
	private WebDriver firefoxDriver = CommerceHook.getFireFoxDriver();
	AccountPage chrome = new AccountPage(chromeDriver);
	AccountPage fire = new AccountPage(firefoxDriver);
	
//	public TestingSteps() {
//		this.driver = CommerceHook.getDriver();
//	}
	
	@Given("^User navigates to OSCommerce HomePage$")
	public void user_navigates_to_OSCommerce_HomePage() throws Throwable {
		//driver = new ChromeDriver();
		String baseUrl = "https://demo.oscommerce.com/index.php";
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.get(baseUrl);
		
		firefoxDriver.manage().window().maximize();
		firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firefoxDriver.get(baseUrl);
	}
	
	@Then("^User navigates to account page$")
	public void user_navigates_to_account_page() throws Throwable {
		chrome.myAccountBtn().click();
		fire.myAccountBtn().click();
	}
	

	@When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_and(String emailAddress, String password) throws Throwable {
		chrome.emailId().sendKeys(emailAddress);
		chrome.password().sendKeys(password);
	    
		fire.emailId().sendKeys(emailAddress);
		fire.password().sendKeys(password);
		
	}

	@When("^User click on Sign In button$")
	public void user_click_on_Sign_In_button() throws Throwable {
		chrome.signInBtn().click();
		fire.signInBtn().click();
	    
	}

	@Then("^User should arrive to account page$")
	public void user_should_arrive_to_account_page() throws Throwable {
		
		String actual = chromeDriver.getCurrentUrl();
		Assert.assertEquals(actual, "https://demo.oscommerce.com/index.php");
		
		String actual2 = firefoxDriver.getCurrentUrl();
		Assert.assertEquals(actual2, "https://demo.oscommerce.com/index.php");
	   
	}
	
	@Then("^User navigates to Account Page$")
	public void user_navigates_to_Account_Page() throws Throwable {
	   chrome.myAccountBtn().click();
	   fire.myAccountBtn().click();
	}

	@When("^User enters invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_invalid_and(String EmailAddress, String Password) throws Throwable {
		
		chrome.emailId().sendKeys(EmailAddress);
		chrome.password().sendKeys(Password);
		
		fire.emailId().sendKeys(EmailAddress);
		fire.password().sendKeys(Password);
	    
	}

	@When("^User clicks on Sign In button$")
	public void user_clicks_on_Sign_In_button() throws Throwable {
		chrome.signInBtn().click();
		
		fire.signInBtn().click();
	   
	}

	@Then("^User should recieve error message$")
	public void user_should_recieve_error_message() throws Throwable {
		
		String errorMsg = chromeDriver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In']")).getText();
		Assert.assertEquals(errorMsg, "Welcome, Please Sign In");
		
		String errorMsg2 = firefoxDriver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In']")).getText();
		Assert.assertEquals(errorMsg2, "Welcome, Please Sign In");
	   
	}

}








