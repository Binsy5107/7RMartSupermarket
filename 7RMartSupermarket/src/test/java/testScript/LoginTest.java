package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPages;
import utilities.ExcelUtility;

public class LoginTest extends Base  {
	@Test(description = "verify user is able to login with valid credentails",priority  = 1,groups = { "smoke" })
	public void veriyUserLoginWithValidCredentials() throws IOException
	{
		HomePage homepage;
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password);
		homepage=loginpage.clicksubmitbutton();
		
		
		//boolean isDashboardDisplayed = logninPage.dashboardDisplayed();
		//Assert.assertTrue(isDashboardDisplayed,"User was unable to login with valid credentials");
		
		
		//boolean isDashboarddisplayed=loginpage.dashboardDispalyed();
		//Assert.assertFalse(isDashboarddisplayed, "user was unable to login with credentials");
		
		
				String actual = loginpage.dashboardDispalyed();
				String expected = "Dashboard";
				Assert.assertEquals(actual, expected,"User was unable to login with valid credentials");
		
				
	}
	@Test(description = "verifying user is not able to login valid username and invalid password", priority  = 2,groups = "smoke")
	public void verifyuserloginwithinvalidusername() throws IOException
	{
		
		
		String username=ExcelUtility.getStringData(1,0,"LoginPages");
		String password=ExcelUtility.getStringData(1,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password).clicksubmitbutton();
		String actual = loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);
		
		
	}
	@Test(description = "verifying user is not able to login with valid username and invalid password",priority = 3)
	public void verifyuserloginwithinvalidpassword() throws IOException 
	{
		String username=ExcelUtility.getStringData(2,0,"LoginPages");
		String password=ExcelUtility.getStringData(2,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password).clicksubmitbutton();
		String actual = loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}
	@Test(description = "verifying user is not able to login with invalid credentials",priority = 4,dataProvider = "logindata")
	public void verifyuserloginwithinvalidcredential(String username,String password) throws IOException
	{
		//String username=ExcelUtility.getStringData(3,0,"LoginPages");
		//String password=ExcelUtility.getStringData(3,1,"LoginPages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password).clicksubmitbutton();
		String actual = loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}

	@DataProvider(name = "logindata")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Test1", "Test2" }, new Object[] { "Test3", "Test4" } };
		// or we can pass values through excel file
		// return new Object[][] { new Object[] { ExcelUtility.getStringData(2, 0,
		// "LoginPage")};
	}

	
	
}