package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Wait until the login button is visible again after a failed login
	    By signInLocator = By.xpath("//button[@type='submit']");
	    WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLocator));
	    
	    return signInButton.getText(); // Should be "Sign In"
	    
	}
}
