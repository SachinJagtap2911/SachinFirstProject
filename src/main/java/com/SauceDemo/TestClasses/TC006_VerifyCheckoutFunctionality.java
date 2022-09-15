package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.CartPagePOMClass;
import com.SauceDemo.POMClasses.CheckOutPagePOMClass;
import com.SauceDemo.POMClasses.HomePagePOMClass;
import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.UtilityClasses.ScreenshotClass;

public class TC006_VerifyCheckoutFunctionality extends TestBaseClass
{
	@Test
	public void checkoutFunctionality() throws IOException, InterruptedException
	{
		// HomePage
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		
		hp.clickAllAddToCart();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("All 6 items added to cart");
		
		hp.clickOnCartLogo();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Cart page opened");	
		
		//cartpage
		CartPagePOMClass cartP = new CartPagePOMClass(driver);
		
		cartP.clickOnCheckoutButton();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Checkout page opened");
		
		// Checkout page
		CheckOutPagePOMClass checkP = new CheckOutPagePOMClass(driver);
		
		checkP.sendFirstName();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("First name entered");
		
		checkP.sendLastName();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Last name entered");

		
		checkP.sendPostalCode();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Postal code entered");

		
		checkP.ClickOncontinueButton();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Clicked on continue button");
		
		// Validation =============================================================================
		String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL, "URL is not matching");
		
		log.info("Validation is applyed");
		
	
		// back to homePage
		log.info("checkout successful and moved on buying page");
		
		driver.navigate().back();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("moved back on Checkout page");
		
		driver.navigate().back();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("moved back on Cart page");
		
		driver.navigate().back();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("moved back on Home page");
		
		
			
	}

}
