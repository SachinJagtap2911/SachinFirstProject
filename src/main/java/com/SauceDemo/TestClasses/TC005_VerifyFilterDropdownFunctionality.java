package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.HomePagePOMClass;
import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.UtilityClasses.ScreenshotClass;

public class TC005_VerifyFilterDropdownFunctionality extends TestBaseClass
{
	@Test
	public void FilterDropdownFunctionality () throws IOException, InterruptedException
	{
		// Filter
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		
		hp.clickOnFilter();
		ScreenshotClass.takeScreenshot(driver);
//		Thread.sleep(2000);
		log.info("Clicked on filter");

		
		//Validation==================================================
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching");
		
		log.info("Validation is applied");

	}

}
