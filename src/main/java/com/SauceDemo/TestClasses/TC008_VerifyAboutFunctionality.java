package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.HomePagePOMClass;
import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.UtilityClasses.ScreenshotClass;

public class TC008_VerifyAboutFunctionality extends TestBaseClass
{
	@Test
	public void aboutFunctionality() throws IOException, InterruptedException
	{
		// Menu
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		
		hp.clickOnMenu();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Clicked on menu button");
		
		hp.clickOnAbout();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Clicked on About button and new Page opened");
		
		
		// Validation=============================================================================
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching");
		
		log.info("Validation is applyed");
		
		// Back to homePage
		driver.navigate().back();
		System.out.println("Moved back on Home page");
		
	}

}
