package UtilsLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseLayer.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener {
		ExtentTest extentTest;
		ExtentReports er;

		public void OnStart(ITestContext context) {
			er= ExtendReportClass.setUp(context.getSuite().getName());
		}

		public void onTestSuccess(ITestResult result) {
           extentTest= er.createTest(result.getMethod().getMethodName());
		}

		public void onTestFailure(ITestResult result) {
			extentTest.log(Status.PASS, "Test case is"+result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromPath(null);
			
		}

		public void onTestSkipped(ITestResult result) {
			extentTest.log(Status.FAIL, "Test case is"+result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromPath(null);
			
		}

	public void onFinish(ITestContext context) {
			
		}
		er=	ExtendReportClass.setUp(context.getSuit().getName());


}
