package SupermarketPageclassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupermarketPageclass {

	public WebDriver driver;
	public SupermarketPageclass(WebDriver driver) 
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")private WebElement  submitbutton;
	
	
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
	


}
