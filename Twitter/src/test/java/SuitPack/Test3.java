package SuitPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import browser.Browser;

public class Test3 extends Browser {
	
	WebDriver driver;
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
	public void verifyText() {
		String actualText = twitterMainPage.getTextForYou();
		String expectedText="For you";
		String actualText1 = twitterMainPage.getTextTrending();
		String expectedText1="Trending";
		
		softAssert.assertEquals(expectedText, actualText);
		softAssert.assertEquals(actualText1, expectedText1);
		softAssert.assertAll();
	}
	@Test
	public void verifyText1() {
		String actualText = twitterMainPage.getTextNews();
		String expectedText="News";
		String actualText1 = twitterMainPage.getTextSports();
		String expectedText1="Sports";
		
		softAssert.assertEquals(actualText, expectedText);
		softAssert.assertEquals(actualText1, expectedText1);
		softAssert.assertAll();
	}
	@Test
	public void verifyText2() {
		String actualText = twitterMainPage.getTextEntertainment();
		String expectedText="Entertainment";
		String actualText1 = twitterMainPage.getTextNewToTwitter();
		String expectedText1="New to Twitter?";
		
		softAssert.assertEquals(actualText, expectedText);
		softAssert.assertEquals(actualText1, expectedText1);
		softAssert.assertAll();
	}
	@AfterMethod
	public void afterMethod() {
		
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
