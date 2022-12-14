package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddProTeacherPage;
import pageObjects.TeacherLoginPage;

public class TC_AddProgramTeacher_001 extends BaseClass{
	
	public static String name;
	@Test
	public void addProgramTeacher() throws Exception
		{
		TeacherLoginPage tlp = new TeacherLoginPage(driver);
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

		AddProTeacherPage addPTeacher = new AddProTeacherPage(driver);
	
		addPTeacher.clickPrograms();
		logger.info("Clicked on Programs");
		
		Thread.sleep(1000);
		addPTeacher.addNewProgram();
		logger.info("Clicked on Add New Program");

		Thread.sleep(1000);
		String name ="AA-" + randomString();
		addPTeacher.proName(name);
		logger.info("Entered Program Name");

		Thread.sleep(1000);
		addPTeacher.progType();
		logger.info("Selected Programe Type");

		addPTeacher.clickOk();
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
