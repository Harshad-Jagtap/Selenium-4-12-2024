package com.crm.Listener;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;

public class Listener extends BaseClass implements ITestListener
{
	File path;
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		System.out.println("ontestStart"+name);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		test.log(Status.PASS,name+"is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		test.log(Status.FAIL,name+"is failed");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		test.log(Status.SKIP,name+"is skipped ");
	}

	@Override
	public void onStart(ITestContext context) {
		//taken file path
		path=new File("./src/test/resources/TroubleTicket.html");
		
		//added path in extent spark reporter
		spark=new ExtentSparkReporter(path);
		
		//configure 
		spark.config().setReportName("Harshad");
		spark.config().setDocumentTitle("Test casess");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		//set system info
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "chrome-11");
		
		//spark report attached
		report.attachReporter(spark);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}