package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteProgramTeacher {
	WebDriver ldriver;

	public DeleteProgramTeacher(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement programs;
	
	@FindBy(how = How.XPATH, using ="	//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div/div[3]/div")
	@CacheLookup
	WebElement rename;

	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div/img[1]")
	@CacheLookup
	WebElement delclk;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[3]")
	@CacheLookup
	WebElement trashcanMenu;
	
	public void clickPrograms()
	{
		programs.click();
	}	
	
	public void rename()
	{
		rename.click();
	}
	
	public void deletePrograme()
	{
		delclk.click();
	}
	
	public void clickTrashCan()
	{
		trashcanMenu.click();
	}
}
