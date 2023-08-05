package UtilsLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtendReportClass extends BaseClass {

		static ExtentReports er;

		public static ExtentReports setUp(String ReportName) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
			String date = sdf.format(new Date());
			ExtentSparkReporter esr = new ExtentSparkReporter(System.getProperty("user.dir") + "//Report//" + ReportName + date + ".html");
			er = new ExtentReports();
			er.attachReporter(esr);
			return er;
			
		}
		
		
		public static String takeScreenShot(String foldername ,String screenshotname) throws IOException 
		{
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
			String date = sdf.format(new Date());
			
			TakesScreenshot ts = null;
			try {
				ts = (TakesScreenshot)getDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"//"+foldername+"//"+screenshotname+date+".png";
			FileUtils.copyFile(src, new File(path));
			return path;
			
		}
	}

