package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInStep2PopUp {
	
	WebDriver driver;
	@FindBy (xpath = "(//span[text()='Next'])[1]")
	private WebElement next;
		
    @FindBy (xpath = "//input[@type='checkbox']")
	private WebElement checkBox;

    public SignInStep2PopUp (WebDriver driver) {
    	PageFactory.initElements(driver,this);
    	this.driver = driver;
    }
    public void clickOnNext2Button() {
    	next.click();
    }
    public void clickOnCheckBox() {
    	boolean check = checkBox.isSelected();
    	
    	if ( check = true) {
    		System.out.println("checked");
    	}
    	else {
    		System.out.println("unchecked");
    		checkBox.click();
    		check = checkBox.isSelected();
    		System.out.println(check);
    	}
    }
}
