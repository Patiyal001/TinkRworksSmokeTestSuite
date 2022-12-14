package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddProTeacherPage {

	WebDriver ldriver;

	public AddProTeacherPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement programs;

	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[3]/div[2]/div/div/div")
	@CacheLookup
	WebElement newProgram;


	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[3]/div[1]/div/input")
	@CacheLookup
	WebElement proName;

	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[3]/div[1]/div/select/option[3]")
	@CacheLookup
	WebElement proType;

	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[3]/div[1]/div/div[4]/button[1]")
	@CacheLookup
	WebElement clkOK;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[3]/div[1]/div/div[3]/button[1]")
	@CacheLookup
	WebElement okStu;

	@FindBy(how = How.ID, using ="dashboard-button")
	@CacheLookup
	WebElement dashboard;

	public void clickPrograms()
	{
		programs.click();
	}

	public void addNewProgram()
	{
		newProgram.click();
	}

	public void proName(String pname)
	{
		proName.sendKeys(pname);
	}

	public void progType()
	{
		proType.click();
	}

	public void clickOk()
	{
		clkOK.click();
	}
	
	public void okStudent()
	{
		okStu.click();
	}
}
