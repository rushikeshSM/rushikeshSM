package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClass.SignInPopUp;
import PomClass.TwitterMainPage;

public class TestClass2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\automation.selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://twitter.com/");
		
		TwitterMainPage twitterMainPage = new TwitterMainPage(driver);
		twitterMainPage.clickOnsignInButton();
	
		SignInPopUp signInPopUp = new SignInPopUp(driver);
		signInPopUp.clickOnTermsOfService();
	}
}
