package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PomClass.SignInPopUp;
import PomClass.SignInStep1PopUp;
import PomClass.SignInStep2PopUp;
import PomClass.SignInStep3PopUp;
import PomClass.TwitterMainPage;
//testpack
public class TestClass1 {
	//signIn 
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","C:\\automation.selenium\\geckodriver-v0.32.1-win32\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://twitter.com/");
		
		TwitterMainPage twitterMainPage = new TwitterMainPage(driver);
		twitterMainPage.clickOnsignInButton();
		
		SignInPopUp signInPopUp = new SignInPopUp(driver);
		Thread.sleep(3000);
		signInPopUp.clickOncreateAccount();
		
		SignInStep1PopUp signInStep1PopUp = new SignInStep1PopUp(driver);
		signInStep1PopUp.enterName("Rushikesh");
		signInStep1PopUp.enterPhone("9359827524");
		signInStep1PopUp.selectMonth();
		signInStep1PopUp.selectDay();
		signInStep1PopUp.selectYear();
		Thread.sleep(3000);
		signInStep1PopUp.clickONextButton();
		
		SignInStep2PopUp signInStep2PopUp = new SignInStep2PopUp(driver);
		signInStep2PopUp.clickOnCheckBox();
		signInStep2PopUp.clickOnNext2Button();
		SignInStep3PopUp signInStep3PopUp = new SignInStep3PopUp(driver);
	//	Thread.sleep(3000);
		signInStep3PopUp.clickOnSignIn();
		driver.close();
		
		
		
		
		
		
	}

}
