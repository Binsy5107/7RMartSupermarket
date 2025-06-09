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
import pages.AdminuserPages;
import pages.LoginPages;
import utilities.ExcelUtility;

public class AdminuserTest extends Base{
	
	
	@Test
	public void verifyabletocraetenewadminuser() throws IOException
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
		
		
		adminuser.clicknewbutton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		
		
		
		adminuser.enterUsernameAdminUser("admin123User");
		adminuser.enterPasswordAdminUser("admin123@User");
		adminuser.selectUserTypeAdminUser("Admin");
		adminuser.clickSaveButton();
		
		
		WebElement alertMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert alert-success')]")));

			String actualMessage = alertMsg.getText().trim();
			String expectedMessage = "User Created Successfully";
			System.out.println("Success Message: " + actualMessage);
			Assert.assertTrue(actualMessage.contains(expectedMessage),"Expected success message not found in alert.");
		
		 
	}
	
	@Test
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
