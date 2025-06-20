package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPages;
import utilities.ExcelUtility;

public class HomeTest extends Base  {
	@Test(description = "verifying user is able to logout")
	public void veriyUserLoginandlogout() throws IOException 
	{
		HomePage homepage;
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password);
		homepage=loginpage.clicksubmitbutton();
		
		
		homepage.clickadminbutton();
		loginpage = homepage.clicklogoutbutton();
		
		
	}
	
	

	
}
