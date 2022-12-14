package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.StudentLoginPage;

public class Type2LoginTest extends BaseClass {
	@Test
	public void type2LoginTest() throws Exception
	{
		StudentLoginPage slp = new StudentLoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		logger.info("URL is opened");
		
		slp.clickHaveAcode();
		logger.info("Clicked on Have a Code");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		slp.clickNumbersDevId();
		logger.info("Clicked on Numbers for Device Id");
		
		Thread.sleep(3000);
		String devID = "00986";
		slp.enterDeviceID(devID);
		logger.info("Entered device id is:" + devID );
		
		Thread.sleep(1000);
		slp.clickNumbersClsId();
		logger.info("Clicked on Numbers for ClassId");
		
		Thread.sleep(1000);
		String classID = "00005";
		slp.enterClassID(classID);
		logger.info("Entered the ClassId");
		
		Thread.sleep(1000);
		slp.clickSubmit();
		logger.info("Clicked on the Submit button");
		
		logger.info("------------Validation Started---------");
		Thread.sleep(1000);
		boolean res = driver.getPageSource().contains("Dashboard");
		Thread.sleep(1000);
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Pass : Type 2 Student Login Passed");
		}
		else
		{
			captureScreen(driver,"");
			Assert.assertTrue(false);
			logger.info("Type 2 Login Test Failed");
		}
}
}
