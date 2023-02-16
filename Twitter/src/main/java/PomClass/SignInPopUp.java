package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPopUp {

	WebDriver driver;
	@FindBy (xpath = "(//span[text()='Create account'])[1]")
	private WebElement createAccount;
	
	@FindBy (xpath = "(//span[text()='Terms of Service'])[1]")
	private WebElement termsOfService;
	
	@FindBy (xpath = "(//span[text()='Privacy Policy'])[1]")
	private WebElement privacyPolicy;
	
	@FindBy (xpath = "(//span[text()='Cookie Use.'])[1]")
	private WebElement cookieUse;
	
	public SignInPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void clickOncreateAccount() {
		createAccount.click();
	}
	public void clickOnTermsOfService() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(termsOfService));
		termsOfService.click();
	}
	public void clickOncookieUse() {
		cookieUse.click();
	}
	public void clickOnPrivacyPolicyLink() {
		privacyPolicy.click();
	}
}
