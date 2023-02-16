package SuitPack;

import java.io.IOException;
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

import PomClass.TwitterMainPage;
import Utils.Utility;
import browser.Browser;

public class Test1 extends Browser{
	
	
	WebDriver driver;
	String TestID;
	SoftAssert softAssert;
	TwitterMainPage twitterMainPage;
	
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
	}
	@BeforeMethod
	public void openUrl() throws InterruptedException {
		softAssert = new SoftAssert();
		driver.get("https://twitter.com/");
		Thread.sleep(5000);	
	}
	@Test
	public void verifyLogInPage() throws InterruptedException {
		TestID = "T_101";
		twitterMainPage.clickOnLogInButton();
		Thread.sleep(5000);
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		String expectedURL = "https://twitter.com/i/flow/login";
		String expectedTitle = "Log in to Twitter / Twitter";
		
		Assert.assertEquals(actualURL, expectedURL);
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
	@Test
	public void verifySignInPage() throws InterruptedException {
		TestID = "T_102";
		twitterMainPage.clickOnsignInButton();
		Thread.sleep(5000);
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		String expectedURL = "https://twitter.com/i/flow/signup";
		String expectedTitle = "Sign up for Twitter / Twitter";
		
		Assert.assertEquals(actualURL, expectedURL);
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE == result.getStatus());{
			Utility.captureScreenshot(driver,"C:\\\\automation.selenium\\\\New folder//", TestID);
		}
		
	}
		@AfterClass
		public void classnull() {
			
			twitterMainPage = null;
			System.gc();
		}
	@AfterTest
		public void close() {
			driver.quit();
				
	    }
}
