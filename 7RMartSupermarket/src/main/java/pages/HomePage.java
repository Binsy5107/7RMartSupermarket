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
	
	//@FindBy(xpath = "//input[@name='username']")private WebElement usernamefield;
	//@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	//@FindBy(xpath = "//button[@type='submit']")private WebElement  submitbutton;
	@FindBy(xpath = "//a[.//img[contains(@src,'avatar5.png')]]")private WebElement adminbutton;
	@FindBy(linkText = "Logout")private WebElement logoutbutton;
	
	// chaining
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
		private WebElement adminusersmoreinfo;
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")
		private WebElement managecategorytab;
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and  @class='small-box-footer']")
		private WebElement Managenewsmoreinfo;

	
	//public HomePage enterusernameonusernamefield()
	//{
		//usernamefield.sendKeys();
		//return this;
	//}
	//public HomePage enterpasswordonpasswordfield()
	//{
	//	passwordfield.sendKeys();
	//	return this;
	//}
	
	//public HomePage clicksubmitbutton()
	//{
	//	submitbutton.click();
		//return this;
	//}
	
	public HomePage clickadminbutton()
	{
		adminbutton.click();
		return this;
			
	}
	
	public LoginPages clicklogoutbutton()
	{
		logoutbutton.click();
		return new LoginPages(driver);
	}
	// Chaining of adminusersmodule

		public AdminuserPages clickOnAdminUsersMoreInfoTab() {
			adminusersmoreinfo.click();
			return new AdminuserPages(driver);
		}

		// chaining of managecategorymodule
		public CategoryPages clickOnManageCategoryTab() {
			managecategorytab.click();
			return new CategoryPages(driver);
		}

		// chaining of managenewsmodule
		public ManagenewsPages clickOnManageNewsTab() {
			Managenewsmoreinfo.click();
			return new ManagenewsPages(driver);
		}

}
