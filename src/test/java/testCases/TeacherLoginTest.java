package testCases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TeacherLoginPage;

public class TeacherLoginTest extends BaseClass{
	@Test
	public void teacherloginTest() throws Exception
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

		if(driver.getTitle().equals("TinkRcode"))
		{
			Assert.assertTrue(true);
			logger.info("Test Pass : Teacher logged in successfully");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Teacher login Test Failed");
		}
	}
}
