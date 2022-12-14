package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddClassesPage;
import pageObjects.TeacherLoginPage;

public class TC_AddNewClass_004 extends BaseClass{
	@Test
	public void addNewClass() throws Exception
	{	
		TeacherLoginPage tlp = new TeacherLoginPage(driver); //These elements are located in the TeacherLoginPage class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(baseURL);
		logger.info("URL is opened");
		
		tlp.setOrgName(org);
		logger.info("Entered Organization name");

		tlp.setAccount(acc);
		logger.info("Entered Account Type");

		tlp.setPassword(pass);
		logger.info("Entered Password");

		tlp.clickSignin();	
		logger.info("Clicked on Signin Button");	

		AddClassesPage clsPge = new AddClassesPage(driver);

		Thread.sleep(1000);
		clsPge.clickClasses();
		logger.info("Clicked on Classes Menu");

		Thread.sleep(1000);		
		clsPge.addNewClass();
		logger.info("Clicked on Create Class button");

		Thread.sleep(1000);
		String name = "ATest-" + randomString();
		clsPge.className(name);
		logger.info("Entered Class Name" + name);

		Thread.sleep(1000);
		clsPge.smartLamp();
		logger.info("Selected Class Type");

		Thread.sleep(1000);
		clsPge.chooseNumbers();
		logger.info("Selected Radio button Numbers");

		Thread.sleep(1000);
		String clsCode = randomNumbers();
		clsPge.enterClassCode(clsCode);
		logger.info("Entered Class Code");

		Thread.sleep(1000);
		clsPge.createClass();
		logger.info("Clicked on Create Class final Button");

		Thread.sleep(1000);

		logger.info("------------Validation Started---------");
		
		boolean res = driver.getPageSource().contains(name);

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Pass : Class is added successfully..!");
		}
		else
		{
			captureScreen(driver,"addNewClass");
			Assert.assertTrue(false);
			logger.info("Test Failed : Class not added yet..!");
		}
	}
}
