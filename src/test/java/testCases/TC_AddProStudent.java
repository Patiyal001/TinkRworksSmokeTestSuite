package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddProTeacherPage;
import pageObjects.StudentLoginPage;

public class TC_AddProStudent extends BaseClass {
	@Test
public void addProgramStudent() throws Exception
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
		
		AddProTeacherPage addPTeacher = new AddProTeacherPage(driver);
		
		addPTeacher.clickPrograms();
		logger.info("Clicked on Programs");
		
		Thread.sleep(1000);
		addPTeacher.addNewProgram();
		logger.info("Clicked on Add New Program");

		Thread.sleep(1000);
		String name ="AAAA-" + randomString();
		addPTeacher.proName(name);
		logger.info("Entered Program Name");

		addPTeacher.okStudent();
		logger.info("Clicked on OK Button");
		System.out.println(name);
		Thread.sleep(3000);
		
		logger.info("------------Validation Started---------");
		boolean res = driver.getPageSource().contains(name);

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Pass : Added a program successfully: " + name);
		}
		else
		{
			captureScreen(driver,"addNewProgram");
			Assert.assertTrue(false);
			logger.info("Add program Test Failed");
		}
}
}
