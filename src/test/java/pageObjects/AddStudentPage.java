package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddStudentPage {

	WebDriver ldriver;
	public AddStudentPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[2]")
	@CacheLookup
	WebElement classes;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div[1]")
	@CacheLookup
	WebElement selClass;
	
	@FindBy(how = How.XPATH, using ="/html/body/div/div/div[3]/div[1]/div[2]/div/div[2]/div[1]")
	@CacheLookup
	WebElement selZZACls;
	
	@FindBy(how = How.XPATH, using ="/html/body/div/div/div[3]/div[1]/div[2]/div/div[3]/div[1]")
	@CacheLookup
	WebElement selZZBClass;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"manage-class\"]/div/div[4]/div/div[3]/div[2]/button")
	@CacheLookup
	WebElement addStu;
	
	@FindBy(how = How.ID, using ="addStudent_name_field0")
	@CacheLookup
	WebElement stuName;
	
	@FindBy(how = How.ID, using ="addStudent_code_field0")
	@CacheLookup
	WebElement devID;

	@FindBy(how = How.XPATH, using ="//*[@id=\"manage-class\"]/div/div[4]/div[1]/div/div[3]/button[1]")
	@CacheLookup
	WebElement addStuBtn;

	public void clickClasses()
	{
		classes.click();
	}
	public void selClassToAdd()
	{
		selClass.click();
	}
	
	public void selOldClassToAdd()
	{
		selZZACls.click();
	}
	
	public void selZZBClass()
	{
		selZZBClass.click();
	}
	
	public void clickAddStudent()
	{
		addStu.click();
	}
	
	public void enterStudentName(String sName)
	{
		stuName.sendKeys(sName);
	}
	
	public void enterDeviceID(String deviceID)
	{
		devID.sendKeys(deviceID);
	}
	
	public void submitAddStudent()
	{
		addStuBtn.click();
	}
}
