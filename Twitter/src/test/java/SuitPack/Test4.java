package SuitPack;
//rushikesh
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PomClass.SignInPopUp;
import PomClass.SignInStep1PopUp;
import PomClass.SignInStep2PopUp;
import PomClass.SignInStep3PopUp;
import PomClass.TwitterMainPage;
import Utils.Utility;
import browser.Browser;

public class Test4 extends Browser{

	
	private WebDriver driver;
	private SoftAssert softAssert;
	private String TestID;
	TwitterMainPage twitterMainPage;
	SignInPopUp signInPopUp;
	SignInStep1PopUp signInStep1PopUp;
	SignInStep2PopUp signInStep2PopUp;
	SignInStep3PopUp signInStep3PopUp;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		if (browserName.equals("Chrome") ) 
		{
			driver = openChromeBrowser();
		}
		if (browserName.equals("Firefox") ) 
		{
			driver = openFirefoxBrowser();
		}
		if (browserName.equals("Opera") ) 
		{
			driver = openOperaBrowser();
		}
		if (browserName.equals("Edge") ) 
		{
			driver = openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void classObject()
	{
		 twitterMainPage = new TwitterMainPage(driver);
		 signInPopUp = new SignInPopUp(driver);
		 signInStep1PopUp = new SignInStep1PopUp(driver);
		 signInStep2PopUp = new SignInStep2PopUp(driver);
		 signInStep3PopUp = new SignInStep3PopUp(driver);
	}
	@BeforeMethod
	public void openUrl() throws InterruptedException    {
		softAssert = new SoftAssert();
		driver.get("https://twitter.com/");
		Thread.sleep(5000);	
		twitterMainPage.clickOnsignInButton();
		Thread.sleep(5000);
		signInPopUp.clickOncreateAccount();
	}
	@Test
	public void verifyTermsOfServiceLink() throws  Exception,NullPointerException   {
		TestID = "103";
		signInStep1PopUp.enterName(Utility.getDataFromExcel("C:\\automation.selenium\\Book2.xlsx","Sheet1", 1, 0));
		String user = Utility.getDataFromExcel("C:\\automation.selenium\\Book2.xlsx","Sheet1", 1, 1);
		signInStep1PopUp.enterPhone(user);
		signInStep1PopUp.selectMonth();
		signInStep1PopUp.selectDay();
		signInStep1PopUp.selectYear();
		Thread.sleep(3000);
		signInStep1PopUp.clickONextButton();
		signInStep2PopUp.clickOnCheckBox();
		signInStep2PopUp.clickOnNext2Button();
		signInStep3PopUp.clickOnSignIn();
	
		
	}
	
	@AfterMethod
	public void closeed(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus());{
			Utility.captureScreenshot(driver,"C:\\automation.selenium\\New folder//", TestID);
		}
		
		driver.close();
	}
	@AfterClass
	public void afterClass() {
		
		signInPopUp = null;
		twitterMainPage = null;
		System.gc();
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
}


