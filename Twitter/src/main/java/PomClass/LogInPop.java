package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPop {
	
	WebDriver driver;
	@FindBy(xpath = "//input[@autocapitalize='sentences']")
	private WebElement phone_email_username;
	
	@FindBy (xpath = "//span[text()='Next']")
	private WebElement next;
	
	@FindBy (xpath = "Forgot password?")
	private WebElement forgotPassord;
	
	public LogInPop(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	public void enterUsername() {
		phone_email_username.sendKeys("rushimagar2");
	}
	public void clickOnNext() {
		next.click();
	}
}
