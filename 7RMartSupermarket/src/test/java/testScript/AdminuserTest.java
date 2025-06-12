package testScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import listeners.listener;
import pages.AdminuserPages;
import pages.LoginPages;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminuserTest extends Base{
	
	
	@Test(description="adding new user to user list",retryAnalyzer=retry.Retry.class)
	public void verifyabletocraetenewadminuser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");// for retry edit the code to fail
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		AdminuserPages adminuser=new AdminuserPages(driver);
		adminuser.clickadminuserbutton();
		
		
		String actual=adminuser.adminuserheadertext();
		String expected="Admin Users";
		Assert.assertEquals(actual,expected ,"failed to load admine user page after login");
		
		
		adminuser.clicknewbutton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		
		RandomDataUtility random=new RandomDataUtility();//fake data
		String usernameadmin=random.createRandomUsername();
		adminuser.enterUsernameAdminUser(usernameadmin);
		String passwordadmin=random.createRandomPassword();
		adminuser.enterPasswordAdminUser(passwordadmin);
		
		//adminuser.enterUsernameAdminUser("admin123User");
		//adminuser.enterPasswordAdminUser("admin123@User");
		adminuser.selectUserTypeAdminUser("Admin");
		adminuser.clickSaveButton();
		
		
		WebElement alertMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert alert-success')]")));

			String actualMessage = alertMsg.getText().trim();
			String expectedMessage = "User Created Successfully";
			System.out.println("Success Message: " + actualMessage);
			Assert.assertTrue(actualMessage.contains(expectedMessage),"Expected success message not found in alert.");
		
		 
	}
	
	@Test(description = "searching added new user in the list")
	public void verifythenewadminuser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		AdminuserPages adminuser=new AdminuserPages(driver);
		adminuser.clickadminuserbutton();
		
		
		String actual=adminuser.adminuserheadertext();
		String expected="Admin Users";
		Assert.assertEquals(actual,expected ,"failed to load admine user page after login");
	
		adminuser.clicksearchButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("un")));
        
		adminuser.entersearchusername("admin123User");
		adminuser.selectusertypedropdown("Admin");
		adminuser.clicksearchbuttoninsearchadminuser();
		
		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'admin123User')]")));
        Assert.assertTrue(result.isDisplayed(), "Search result for 'admin123User' was not displayed.");
	    
	    
	}
	

}
