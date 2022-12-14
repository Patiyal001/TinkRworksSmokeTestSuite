package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherLoginPage {
	WebDriver ldriver;

	public TeacherLoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="organization")
	@CacheLookup
	WebElement txtOrg;

	@FindBy(id="user")
	@CacheLookup
	WebElement txtAcc;

	@FindBy(id="pw")
	@CacheLookup
	WebElement txtPass;

	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset/div[4]/button")
	@CacheLookup
	WebElement clksignin;

	@FindBy(xpath="//*[@id=\"content\"]/div[2]/a")
	@CacheLookup
	WebElement useCode;

	public void setOrgName(String orgName )
	{
		txtOrg.sendKeys(orgName);
	}

	public void setAccount(String account)
	{
		txtAcc.sendKeys(account);
	}

	public void setPassword(String pass)
	{
		txtPass.sendKeys(pass);
	}

	public void clickSignin()
	{
		clksignin.click();
	}

	public void useAcode()
	{
		useCode.click();
	}
}
