package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(xpath = "//input[@name='username']")private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")private WebElement  submitbutton;
	@FindBy(xpath = "//a[.//img[contains(@src,'avatar5.png')]]")private WebElement adminbutton;
	@FindBy(linkText = "Logout")private WebElement logoutbutton;
	
	public void enterusernameonusernamefield(String username)
	{
		usernamefield.sendKeys(username);
	}
	public void enterpasswordonpasswordfield(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void clicksubmitbutton()
	{
		submitbutton.click();
	}
	
	public void clickadminbutton()
	{
		adminbutton.click();
			
	}
	
	public void clicklogoutbutton()
	{
		logoutbutton.click();
	}

}
