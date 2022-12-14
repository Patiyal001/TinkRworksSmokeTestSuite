package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddClassesPage {

	WebDriver ldriver;
	
	public AddClassesPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[2]")
	@CacheLookup
	WebElement classes;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[3]/div[2]/div/div/div")
	@CacheLookup
	WebElement newClass;
	
	@FindBy(how = How.ID, using ="name")
	@CacheLookup
	WebElement clsName;

	@FindBy(how = How.XPATH, using ="//*[@id=\"create-class\"]/div/div[4]/div[2]/form/fieldset/div[2]/select/option[3]")
	@CacheLookup
	WebElement clsTypeSmrtlmp;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[2]/div/div[4]/div[2]/form/fieldset/div[2]/select/option[9]")
	@CacheLookup
	WebElement clsTypeTinkRbot;
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[2]/div/div[4]/div[2]/form/fieldset/div[3]/div[1]/div/div[1]/input[2]")
	@CacheLookup
	WebElement rbtnNums;
		
	@FindBy(how = How.ID, using ="codeField")
	@CacheLookup
	WebElement classCode;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"create-class\"]/div/div[4]/div[2]/form/fieldset/div[3]/div[2]/button")
	@CacheLookup
	WebElement createCls;

	public void clickClasses()
	{
		classes.click();
	}
	
	public void addNewClass()
	{
		newClass.click();
	}
	
	public void className(String cName)
	{
		clsName.sendKeys(cName);
	}
	
	public void smartLamp()
	{
		clsTypeSmrtlmp.click();
	}
	
	public void tinkRbot()
	{
		clsTypeTinkRbot.click();
	}
	
	public void chooseNumbers()
	{
		rbtnNums.click();
	}
	
	public void enterClassCode(String cCode)
	{
		classCode.sendKeys(cCode);
	}
	
	public void createClass()
	{
		createCls.click();
	}

}
