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

public class AddItemToCartStepDef {
	private WebDriver chromeDriver = CommerceHook.getChromeDriver();
	private WebDriver firefoxDriver = CommerceHook.getFireFoxDriver();
	AccountPage chrome = new AccountPage(chromeDriver);
	AccountPage fire = new AccountPage(firefoxDriver);
	
	@Given("^UseR Navigates To OSCoMMerce HomEPage$")
	public void user_Navigates_To_OSCoMMerce_HomEPage() throws Throwable {
		
		String baseUrl = "https://demo.oscommerce.com/index.php";
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.get(baseUrl);
		
		firefoxDriver.manage().window().maximize();
		firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firefoxDriver.get(baseUrl);
	}

	@Then("^UseR Navigates TO Account Page$")
	public void user_Navigates_TO_Account_Page() throws Throwable {
		chrome.myAccountBtn().click();
		fire.myAccountBtn().click();
	}

	@When("^UseR Enters ValiD \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Enters_ValiD_and(String EmailAddress, String Password) throws Throwable {
		chrome.emailId().sendKeys(EmailAddress);
		chrome.password().sendKeys(Password);
	    
		fire.emailId().sendKeys(EmailAddress);
		fire.password().sendKeys(Password);
	    
	}

	@When("^UseR Click on SigN in Button$")
	public void user_Click_on_SigN_in_Button() throws Throwable {
		chrome.signInBtn().click();
		fire.signInBtn().click();
	    
	}

	@Then("^UseR Should Arrive To Account Page$")
	public void user_Should_Arrive_To_Account_Page() throws Throwable {
		String actual = chromeDriver.getCurrentUrl();
		Assert.assertEquals(actual, "https://demo.oscommerce.com/account.php");
		
		String actual2 = firefoxDriver.getCurrentUrl();
		Assert.assertEquals(actual2, "https://demo.oscommerce.com/account.php");
	   
	   
	}

	@When("^User clicks on Hardware Tab$")
	public void user_clicks_on_Hardware_Tab() throws Throwable {
		chrome.hardware().click();
		fire.hardware().click();
	    
	}

	@When("^User selects graphics card tab and select graphic card$")
	public void user_selects_graphics_card_tab_and_select_graphic_card() throws Throwable {
		chrome.graphicsCard().click();
		chrome.buyMatrox200().click();
		
		fire.graphicsCard().click();
		fire.buyMatrox200().click();
	    
	}

	@Then("^User add item to cart$")
	public void user_add_item_to_cart() throws Throwable {
		chrome.addToCart().click();
		fire.addToCart().click();
	    
	}

	@Then("^User clicks check out button$")
	public void user_clicks_check_out_button() throws Throwable {
		chrome.checkOutBtn().click();
		fire.checkOutBtn().click();
	   
	}

}
