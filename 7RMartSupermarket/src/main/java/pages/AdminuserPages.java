package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminuserPages {
	
	public WebDriver driver;
	public AdminuserPages(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(xpath = "//input[@name='username']")private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")private WebElement  submitbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class, 'small-box-footer')]")private WebElement adminuser;
	@FindBy(xpath = "//h1[contains(text(),'Admin Users')]")private WebElement adminuserheader;
	@FindBy(xpath = "//a[contains(@class, 'btn-rounded') and @onclick='click_button(1)']")private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")private WebElement usernameadminuser;
	@FindBy(xpath = "//input[@id='password']")private WebElement passwordadminuser;
	@FindBy(xpath = "//select[@id='user_type']")private WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")private WebElement saveButton;
	
	
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")private WebElement searchusername;
	@FindBy(xpath = "//select[@id='ut']")private WebElement searchuserTypeDropdown;
	@FindBy(xpath = "//button[@name='Search' and @value='sr']")private WebElement searchbuttoninsearchadminuser;

	
	
	public void clickadminuserbutton()
	{
		adminuser.click();
	}
	public String adminuserheadertext()
	{
		return adminuserheader.getText();
	}
	public void clicknewbutton() 
	{
		newbutton.click();
	}
	
	public void enterUsernameAdminUser(String username) 
	{
	    usernameadminuser.sendKeys(username);
	}
	
	
	public void enterPasswordAdminUser(String password) {
	    passwordadminuser.sendKeys(password);
	}

	public void selectUserTypeAdminUser(String usertype) 
	{
		Select dropdown=new Select(userTypeDropdown);
	   dropdown.selectByVisibleText(usertype);
	}
	public void clickSaveButton() {
	    saveButton.click();
	}
	
	public void  clicksearchButton() {
		searchButton.click();
		
	}
	public void entersearchusername(String username)
	{
		searchusername.sendKeys(username);
	}
	
	public void selectusertypedropdown(String usertype)
	{
		Select dropdown=new Select(searchuserTypeDropdown);
		   dropdown.selectByVisibleText(usertype);
	}
	
	public void clicksearchbuttoninsearchadminuser()
	{
		searchbuttoninsearchadminuser.click();
	}
	
	
}
