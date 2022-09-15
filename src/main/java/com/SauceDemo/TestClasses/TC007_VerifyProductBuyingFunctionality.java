package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.BillingPage;
import com.SauceDemo.POMClasses.CartPagePOMClass;
import com.SauceDemo.POMClasses.CheckOutPagePOMClass;
import com.SauceDemo.POMClasses.EndPagePOMClass;
import com.SauceDemo.POMClasses.HomePagePOMClass;
import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.UtilityClasses.ScreenshotClass;

public class TC007_VerifyProductBuyingFunctionality extends TestBaseClass
{
	@Test
	public void  buyingFunctionality() throws IOException, InterruptedException
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
		
		//cartPage
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
		
		System.out.println("Checkout successful and moved on buying page");
		
		// Buy page
		BillingPage bp = new BillingPage(driver);
		
		bp.clickOnFinishButton();
//		Thread.sleep(2000);
		log.info("Clicked on finish button and end page opened");
		
		
		// Validation ================================================================================
		
		String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL, "URL is not matching");
		
		log.info("Validation is applyed");
		
		// Back to homePage
		EndPagePOMClass endP = new EndPagePOMClass(driver);
		
		endP.clickOnBackHomeButton();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		System.out.println("Clicked on Back Home button");
		
		
		
		
	}

}
