package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPages;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test
	public void veriyUserLoginWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(10, 0, "Loginpages");
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
	
	@Test
	public void verifyuserloginwithinvalidusername() throws IOException
	{
		
		
		String username=ExcelUtility.getStringData(1,0,"LoginPages");
		String password=ExcelUtility.getStringData(1,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		
	}
	
	@Test
	public void verifyuserloginwithinvalidpassword() throws IOException 
	{
		String username=ExcelUtility.getStringData(2,0,"LoginPages");
		String password=ExcelUtility.getStringData(2,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
	}
	
	@Test
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
