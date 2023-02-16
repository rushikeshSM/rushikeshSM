package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInStep1PopUp {
	WebDriver driver;
	@FindBy (xpath ="(//input[@autocapitalize='sentences'])[1]")
	private WebElement name;
	
	@FindBy (xpath = "(//input[@autocapitalize='sentences'])[2]")
	private WebElement phone;
	
	@FindBy (xpath ="(//select[@aria-invalid='false'])[1]")
	private WebElement month;
	
	@FindBy (xpath = "(//select[@aria-invalid='false'])[2]")
	private WebElement day;
	
	@FindBy (xpath = "(//select[@aria-invalid='false'])[3]")
	private WebElement year;
	
	@FindBy (xpath = "(//span[text()='Next'])[1]")
	private WebElement next;
	
	public SignInStep1PopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void enterName(String username) {
		name.sendKeys(username);
	}
	public void enterPhone(String number) {
		phone.sendKeys(number);
	}
	public void selectMonth() {
		Select m = new Select (month);
		m.selectByIndex(9);
	}
	public void selectDay() {
		Select d = new Select(day);
		d.selectByValue("14");
	}
	public void selectYear() {
		Select y = new Select(year);
		y.selectByVisibleText("1999");
	}
	public void clickONextButton() {
		next.click();
	}
	


}
