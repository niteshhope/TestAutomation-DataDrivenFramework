package com.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String,String> data)
			throws InterruptedException {
		if (!data.get("runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as Run Mode is No");

		}
		click("addcustBtn_CSS");
		type("firstname_CSS", data.get("firstname"));
		type("lastname_XPATH",data.get("lastname"));
		type("postcode_CSS", data.get("postcode"));
		click("addbtn_CSS");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		// Assert.fail("customer not add successfully");

	}

}
