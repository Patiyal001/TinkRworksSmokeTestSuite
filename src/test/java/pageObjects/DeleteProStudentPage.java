package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteProStudentPage {
	
	WebDriver ldriver;
	public DeleteProStudentPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement programs;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div/img[1]")
	@CacheLookup
	WebElement clkdel;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div/div[3]/div")
	@CacheLookup
	WebElement rename;
	
	
	public void clickPro()
	{
		programs.click();
	}
 
	public void clickdelete()
	{
		clkdel.click();
	}
 
	public void clickRename()
	{
		rename.click();	 
	}

	
}

