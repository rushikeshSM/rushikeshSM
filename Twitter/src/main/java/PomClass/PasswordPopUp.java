package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPopUp {

	WebDriver driver;
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "(//span[text()='Log in'])[2]")
	private WebElement logIn;
	
	public PasswordPopUp(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver = driver;
	}
	public void enterPassword() {
		password.sendKeys("Detonator295");
	}
	public void clickOnLogIn() {
		logIn.click();
	}
}
