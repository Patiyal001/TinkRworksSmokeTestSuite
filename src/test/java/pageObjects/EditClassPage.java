package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditClassPage {

	WebDriver ldriver;
	
	public EditClassPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[2]")
	@CacheLookup
	WebElement classes;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div[1]/div[3]/div")
	@CacheLookup
	WebElement clkEdit;
	
	@FindBy(how = How.ID, using ="name")
	@CacheLookup
	WebElement clsName;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"create-class\"]/div/div[4]/div[2]/form/fieldset/div[2]/select/option[3]")
	@CacheLookup
	WebElement clsType;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"radio_buttons\"]/input[2]")
	@CacheLookup
	WebElement rbtnNums;
	
	
	@FindBy(how = How.ID, using ="codeField")
	@CacheLookup
	WebElement classCode;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"create-class\"]/div/div[4]/div[2]/form/fieldset/div[3]/div[2]/button")
	@CacheLookup
	WebElement editClass;
	
	public void clickClasses()
	{
		classes.click();
	}
	
	public void editClass()
	{
		clkEdit.click();
	}
	
	public void className(String cName)
	{
		clsName.clear();
		clsName.sendKeys(cName);
	}
	
	public void classType()
	{
		clsType.click();
	}
	
	public void chooseNumbers()
	{
		rbtnNums.click();
	}
	
	public void enterClassCode(String cCode)
	{
		classCode.clear();
		classCode.sendKeys(cCode);
	}
		
	public void editSubmit()
	{
		editClass.click();
	}
}