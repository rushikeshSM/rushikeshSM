package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInStep3PopUp {
	WebDriver driver;
	@FindBy (xpath = "(//span[text()='Sign up'])[2]")
	private WebElement signIn;
	
	public SignInStep3PopUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}

	public void clickOnSignIn() {
		signIn.click();
	}
}
