package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RemoveStudentPage {

	WebDriver ldriver;
	public RemoveStudentPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[2]")
	@CacheLookup
	WebElement classes;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div[1]")
	@CacheLookup
	WebElement clkClass;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"studentDataTable\"]/tbody/tr/td[3]/button[2]")
	@CacheLookup
	WebElement rmvBtn;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[2]/div/div[6]/button[1]")
	@CacheLookup
	WebElement confrmv;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"manage-class\"]/div/div[4]/div/div[3]/div[1]/h3/text()[2]")
	@CacheLookup
	WebElement countstu;
	
	

	public void clickClasses()
	{
		classes.click();
	}
	
	public void clickonaClass()
	{
		clkClass.click();
	}
	
	public void clickRemoveBtn()
	{
		rmvBtn.click();
	}
	
	public void confirmRemove()
	{
		confrmv.click();
	}
	
}
