package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteClassPage {
	WebDriver ldriver;
	
	public DeleteClassPage(WebDriver rdriver)
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
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div[1]/img[1]")
	@CacheLookup
	WebElement delbtn;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[2]/div/input[1]")
	@CacheLookup
	WebElement inDel;
	@FindBy(how = How.XPATH, using ="	/html/body/div[2]/div/div[6]/button[1]")
	@CacheLookup
	WebElement clkDel;

	public void clickClasses()
	{
		classes.click();
	}
		
	public void selectClass() 
	{
		selClass.click();
	}
	
	public void clickkDeleteIcon()
	{
		delbtn.click();
	}
	
	public void typingDelete(String typeDel )
	{
		inDel.sendKeys(typeDel);
	}
	
	public void clickDelete()
	{
		clkDel.click();
	}
}
