package SuitPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import PomClass.TwitterMainPage;
import Utils.Utility;
import browser.Browser;

public class Test2 extends Browser{

	private WebDriver driver;
	private SoftAssert softAssert;
	private String TestID;
	TwitterMainPage twitterMainPage;
	SignInPopUp signInPopUp;
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
	}
	@BeforeMethod
	public void openUrl() throws InterruptedException {
		softAssert = new SoftAssert();
		driver.get("https://twitter.com/");
		Thread.sleep(5000);	
		twitterMainPage.clickOnsignInButton();
	}
	@Test
	public void verifyTermsOfServiceLink() throws InterruptedException{
		TestID = "103";
		SignInPopUp signInPopUp = new SignInPopUp(driver);
		Thread.sleep(5000);
		signInPopUp.clickOnTermsOfService();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		String expectedURL = "https://twitter.com/en/tos";
		String expectedTitle = "Twitter Terms of Service";
		
		softAssert.assertEquals(actualURL, expectedURL);
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
	@Test
	public void verifyPrivacyPolicyLink() throws InterruptedException {
		TestID = "104";
		SignInPopUp signInPopUp = new SignInPopUp(driver);
		Thread.sleep(5000);
		signInPopUp.clickOnPrivacyPolicyLink();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		String expectedURL = "https://twitter.com/en/privacy";
		String expectedTitle = "Twitter Privacy Policy";
		
		Assert.assertEquals(actualURL, expectedURL);
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
	@Test
	public void verifyCookiesUseLink() throws InterruptedException {
		TestID = "105";
		Thread.sleep(5000);
		signInPopUp.clickOncookieUse();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		String expectedURL = "https://help.twitter.com/en/rules-and-policies/twitter-cookies";
		String expectedTitle = "How cookies are used on Twitter | Twitter Help";
		
		Assert.assertEquals(actualURL, expectedURL);
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
	@AfterMethod
	public void closeed(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus());{
			Utility.captureScreenshot(driver,"C:\\\\automation.selenium\\\\New folder//", TestID);
		}
		
		driver.close();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
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
