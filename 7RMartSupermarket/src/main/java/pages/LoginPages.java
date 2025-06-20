
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

	public WebDriver driver;
	public LoginPages(WebDriver driver) 
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")private WebElement  submitbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")private WebElement dashboard;
	
	
	
	public LoginPages enterusernameonusernamefield(String username)
	{
		usernamefield.sendKeys(username);
		return this;
	}
	public LoginPages enterpasswordonpasswordfield(String password)
	{
		passwordfield.sendKeys(password);
		return this;
	}
	public HomePage clicksubmitbutton()
	{
		submitbutton.click();
		return new HomePage(driver);
	}
	public String dashboardDispalyed()
	{
	//return Dashboard.isDisplayed();
	return dashboard.getText();
}
	public String signInPageDisplayed() {
		return submitbutton.getText();
	}

}
