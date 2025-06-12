package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPages;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(description = "verify user is able to login with valid credentails",priority  = 1)
	public void veriyUserLoginWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		
		//boolean isDashboardDisplayed = logninPage.dashboardDisplayed();
		//Assert.assertTrue(isDashboardDisplayed,"User was unable to login with valid credentials");
		
		
		//boolean isDashboarddisplayed=loginpage.dashboardDispalyed();
		//Assert.assertFalse(isDashboarddisplayed, "user was unable to login with credentials");
		
		
				String actual = loginpage.dashboardDispalyed();
				String expected = "Dashboard";
				Assert.assertEquals(actual, expected,"User was unable to login with valid credentials");
				
	}
	
	@Test(description = "verifying user is not able to login valid username and invalid password", priority  = 2)
	public void verifyuserloginwithinvalidusername() throws IOException
	{
		
		
		String username=ExcelUtility.getStringData(1,0,"LoginPages");
		String password=ExcelUtility.getStringData(1,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		
	}
	
	@Test(description = "verifying user is not able to login with valid username and invalid password",priority = 3)
	public void verifyuserloginwithinvalidpassword() throws IOException 
	{
		String username=ExcelUtility.getStringData(2,0,"LoginPages");
		String password=ExcelUtility.getStringData(2,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
	}
	
	@Test(description = "verifying user is not able to login with invalid credentials",priority = 4)
	public void verifyuserloginwithinvalidcredential() throws IOException
	{
		String username=ExcelUtility.getStringData(3,0,"LoginPages");
		String password=ExcelUtility.getStringData(3,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
	}
	
	
}
