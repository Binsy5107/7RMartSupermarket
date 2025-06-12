package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPages;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description = "verifying user is able to logout")
	public void veriyUserLoginandlogout() throws IOException 
	{
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		
		HomePage logoutPage = new HomePage(driver);
		logoutPage.clickadminbutton();
		logoutPage.clicklogoutbutton();
		
		
		
	}
	
	
	

}
