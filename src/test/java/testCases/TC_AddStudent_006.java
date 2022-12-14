package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddStudentPage;
import pageObjects.TeacherLoginPage;

public class TC_AddStudent_006 extends BaseClass{
	@Test
	public void addingStudent() throws Exception
	{
		TeacherLoginPage lp = new TeacherLoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();



		driver.get(baseURL);
		logger.info("URL is opened");



		lp.setOrgName(org);
		logger.info("Entered Organization name");



		lp.setAccount(acc);
		logger.info("Entered Account Type");


		lp.setPassword(pass);
		logger.info("Entered Password");

		lp.clickSignin();    
		logger.info("Clicked on Signin Button");        

		AddStudentPage addStu = new AddStudentPage(driver);
		addStu.clickClasses();
		logger.info("Clicked on the Classes Menu");

		addStu.selClassToAdd();
		logger.info("Selecting the class to Add the Student");


		Thread.sleep(1000);
		addStu.clickAddStudent();
		logger.info("Clicking on Add Student Button");                       

		Thread.sleep(1000);
		String name = "ANUJ-" + randomString();
		addStu.enterStudentName(name);
		logger.info("Entered Student Name");

		Thread.sleep(1000);
		//String devID = "";
		String devID ="00"+ randomNumbers3();
		addStu.enterDeviceID(devID);
		logger.info("Entered Device Id");


		addStu.submitAddStudent();
		logger.info("Clicked on Add Student button");




		logger.info("------------Validation Started---------");
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("User added successfully.");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Pass : Added the Student successfully");
		}
		else
		{
			captureScreen(driver,"addNewStudent");
			Assert.assertTrue(false);
			logger.info("Add Student Test Failed");
		}
	}
}
