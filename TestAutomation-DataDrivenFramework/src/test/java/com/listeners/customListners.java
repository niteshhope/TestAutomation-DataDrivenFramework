package com.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.poi.util.SystemOutLogger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.MonitoringMail;
import com.utilities.TestConfig;
import com.utilities.TestUtil;


public class customListners extends TestBase implements ITestListener, ISuiteListener
{
	public String messageBody;
	
	public void onFinish(ITestContext arg0) {
		MonitoringMail mail = new MonitoringMail();

		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenFramework/Extent_20Report/";
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		  System.setProperty("org.uncommons.reportng.escape-output", "false");
      try {
		TestUtil.captureScreenShot();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	 test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with Exception"+arg0.getThrowable());
	 test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

	
      Reporter.log("<a href="+TestUtil.screenshotName+">Screenshot</a>");
      Reporter.log("<br>");
      Reporter.log("<br>");
     // image of second test case capture -- driver control not going there
      Reporter.log("<a href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=1100 width=1100</img></a>" );
 
  	rep.endTest(test);
	rep.flush();
}
       
		
		

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+"skipped the test as Run mode is No");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult arg0) {
		test=rep.startTest(arg0.getName().toUpperCase());
		
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");
		rep.endTest(test);
		rep.flush();
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}
