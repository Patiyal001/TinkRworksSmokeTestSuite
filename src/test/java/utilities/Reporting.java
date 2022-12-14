package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("dd.MMM.yyyy.HH.mm.ss").format(new Date()); //timestamp
		String repName ="Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter((System.getProperty("user.dir")+"/test-output/"+repName));
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}


		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("Enviornment", "Testing");
		extent.setSystemInfo("Tester", "ANUJ KUMAR");

		sparkReporter.config().setDocumentTitle("TinkRworks Test Project"); // Title of the report
		sparkReporter.config().setReportName("TinkRworks Smoke Test Report"); //name of the report // Location of chart
		sparkReporter.config().setTheme(Theme.DARK);

	}
	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.PASS, "TEST CASE PASSED IS  : " + tr.getName());//Send the passed information
	}

	public void onTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, "TEST CASE FAILED IS  : " + tr.getName());// send the passed information
		logger.log(Status.FAIL, "TEST CASE FAILED IS  : " + tr.getThrowable());// To add error/Exceptions
		String timeStamp = new SimpleDateFormat("dd.MMM.yyyy.HH.mm.ss").format(new Date());
		String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+timeStamp+".png";
		File f = new File(screenshotPath);
		if(f.exists())
		{
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));

		}
	}
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.SKIP, "TEST CASE SKIPPED IS  : " + tr.getName());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}





