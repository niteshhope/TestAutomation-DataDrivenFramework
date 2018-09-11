package com.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.base.TestBase;

public class BankManagerLoginTest extends TestBase  {
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {
		verifyEquals("abc", "xyz");
		log.debug("Inside Login Test");
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addcustBtn_CSS"))), "Login not sucessful");
		log.debug("Login successfully executed");
		// Reporter.log("Login successfully executed");


	}
}
	
