package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL=readconfig.getApplicaitonURL();
	public String org=readconfig.getOrganization();
	public String acc=readconfig.getAccType();
	public String pass=readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{

		logger = Logger.getLogger("tinkRblocks");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}

		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}


	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws Exception {
		String timeStamp = new SimpleDateFormat("dd.MMM.yyyy.HH.mm.ss").format(new Date());
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" +tname + timeStamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		return (generatedstring);
	}
	
	public String randomNumbers()
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(5);
		return (generatedstring2);
	}
	
	public String randomNumbers3()
	{
		String generatestring3 =RandomStringUtils.randomNumeric(3); 
		return(generatestring3);
	}
}
