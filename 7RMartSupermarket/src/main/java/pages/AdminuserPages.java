
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.constant;
import utilities.PageUtility;

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

	
	
	public AdminuserPages clickadminuserbutton()
	{
		adminuser.click();
		return this;
	}
	public String adminuserheadertext()
	{
		return adminuserheader.getText();
	}
	public AdminuserPages clicknewbutton() 
	{
		newbutton.click();
		return this;
	}
	
	public AdminuserPages enterUsernameAdminUser(String username) 
	{
	    usernameadminuser.sendKeys(username);
	    return this;
	}
	
	
	public AdminuserPages enterPasswordAdminUser(String password) {
	    passwordadminuser.sendKeys(password);
	    return this;
	}

	public AdminuserPages selectUserTypeAdminUser() 
	{
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(userTypeDropdown,constant.USERTYPE);
		//Select dropdown=new Select(userTypeDropdown);
	   //dropdown.selectByVisibleText(usertype);
		return this;
	}
	public AdminuserPages clickSaveButton() {
	    saveButton.click();
	    return this;
	}
	
	public AdminuserPages  clicksearchButton() {
		searchButton.click();
		return this;
		
	}
	public AdminuserPages entersearchusername()
	{
		searchusername.sendKeys(constant.SEARCHADMINUSERNAME);
		return this;
	}
	
	public AdminuserPages selectusertypedropdown()
	{
		PageUtility page= new PageUtility();
		page.selectDropdownWithVisibleText(searchuserTypeDropdown, constant.USERTYPE);
		//Select dropdown=new Select(searchuserTypeDropdown);
		  // dropdown.selectByVisibleText(usertype);
		return this;
	}
	
	public AdminuserPages clicksearchbuttoninsearchadminuser()
	{
		searchbuttoninsearchadminuser.click();
		return this;
	}
	
}
