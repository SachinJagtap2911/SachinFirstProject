package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.HomePagePOMClass;
import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.UtilityClasses.ScreenshotClass;

public class TC004_VerifyMultipleAddToCartFunctionality extends TestBaseClass
{
	@Test
	public void multipleAddToCartFunctionality() throws InterruptedException, IOException
	{
		// allItemsAddToCart
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		
		hp.clickAllAddToCart();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("All 6 items added to cart");
		
		// Validation================================================================================
		String expectedCount = "3";
        String actualCount = hp.getTextFromCartButton();
		
	    Assert.assertEquals(actualCount, expectedCount, "Count is not matching");
	    
		log.info("Validation is applied");

	}
	
}
