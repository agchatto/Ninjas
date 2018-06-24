package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='tdb3']/span[2]")
	WebElement myAccountBtn;
	
	@FindBy(name = "email_address")
	WebElement emailId;
	
	@FindBy (name = "password")
	WebElement password;
	
	@FindBy (xpath = "//span[text()='Sign In']")
	WebElement signInBtn;
	
	@FindBy (xpath = "//a[text()='View or change my account information.']")
	WebElement acctInfo;
	
	@FindBy (xpath = "//div[@id='columnLeft']//a[@href='https://demo.oscommerce.com/index.php?cPath=1']")
	WebElement hardware;
	
	@FindBy (xpath = "//*[@id='columnLeft']/div[1]/div[2]/a[3]")
	WebElement graphicsCard;
	
	@FindBy (id = "tdb5")
	WebElement buyMatrox200;
	
	@FindBy (id = "tdb5")
	WebElement addToCart;
	
	@FindBy (id = "tdb6")
	WebElement checkOutBtn;
	
	@FindBy (id = "tdb4")
	WebElement signOutBtn;
	
	public WebElement myAccountBtn() {
		return myAccountBtn;
	}
	
	public WebElement emailId() {
		return emailId;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement signInBtn() {
		return signInBtn;
	}
	
	public WebElement acctInfo() {
		return acctInfo;
	}
	
	public WebElement hardware() {
		return hardware;
	}
	
	public WebElement graphicsCard() {
		return graphicsCard;
	}
	
	public WebElement buyMatrox200() {
		return buyMatrox200;
	}
	
	public WebElement addToCart() {
		return addToCart;
	}
	
	public WebElement checkOutBtn() {
		return checkOutBtn;
	}
	
	public WebElement signOutBtn () {
		return signOutBtn;
	}

}
