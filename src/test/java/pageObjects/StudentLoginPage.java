package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLoginPage {
	WebDriver ldriver;

	public StudentLoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/a")
	@CacheLookup
	WebElement hvaCode;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/form/div/div/div[2]/div[1]/div[1]/input[2]")
	@CacheLookup
	WebElement clkNumdevid;

	@FindBy(name="devicecode")
	@CacheLookup
	WebElement deviceID;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/form/div/div/div[1]/div[1]/div[1]/input[2]")
	@CacheLookup
	WebElement clkNumClsid;
	
	@FindBy(name="classcode")
	@CacheLookup
	WebElement classId;
	
	@FindBy(id="LoginForm")
	@CacheLookup
	WebElement clickSubmit;
	
	public void clickHaveAcode()
	{
		hvaCode.click();
	}
	
	public void clickNumbersDevId()
	{
		clkNumdevid.click();
	}
	
	public void enterDeviceID(String deviceid)
	{
		deviceID.sendKeys(deviceid);
	}
	
	public void clickNumbersClsId()
	{
		clkNumClsid.click();
	}
	
	public void enterClassID(String clsID)
	{
		classId.sendKeys(clsID);	
	}
	
	public void clickSubmit()
	{
		clickSubmit.click();	
	}
	}

