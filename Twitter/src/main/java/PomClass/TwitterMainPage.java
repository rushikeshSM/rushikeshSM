package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterMainPage {
	WebDriver driver;
	@FindBy (xpath = "//span[text()='Log in']")
	private WebElement logIn;
	
	@FindBy (xpath = "//span[text()='Sign up']")
	private WebElement signIn;
	
	@FindBy (xpath = "//span[text()='New to Twitter?']")
	private WebElement newToTwitter;
	
	@FindBy (xpath = "//span[text()='For you']")
	private WebElement forYou;
	
	@FindBy (xpath = "//span[text()='Trending']")
	private WebElement trending;
	
	@FindBy (xpath = "//span[text()='News']")
	private WebElement news;
	
	@FindBy (xpath = "//span[text()='Sports']")
	private WebElement sports;
	
	@FindBy (xpath ="//span[text()='Entertainment']")
	private WebElement entertainment;
	
	public TwitterMainPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public void clickOnLogInButton() {
		logIn.click();
	}
	public void clickOnsignInButton() {
		signIn.click();
	}
	public String getTextNewToTwitter() {
		String text = newToTwitter.getText();
		return text;
	}
	public String getTextForYou() {
		String text = forYou.getText();
		return text;
	}
	public String getTextTrending() {
		String text = trending.getText();
		return text;
	}
	public String getTextNews() {
		String text = news.getText();
		return text;
	}
	public String getTextSports() {
		String text = sports.getText();
		return text;
	}
	public String getTextEntertainment() {
		String text = entertainment.getText();
		return text;		
	}


}
