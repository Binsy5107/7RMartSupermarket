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
import pages.HomePage;
import pages.LoginPages;
import pages.ManagenewsPages;
import utilities.ExcelUtility;

public class ManagenewsTest extends Base {
	
	@Test(description = "adding new manage news to the list")
	public void veriyabletocreatemangenews() throws IOException 
	{
		HomePage homepage;
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password);
		homepage=loginpage.clicksubmitbutton();
		
		
		ManagenewsPages managenewspage=new ManagenewsPages(driver);
		homepage.clickOnManageNewsTab();
		
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement newbutton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-rounded.btn-danger")));
		    
		    String actual = managenewspage.getManageNewsHeaderText();
		    String expected = "Manage News";
		    Assert.assertEquals(actual, expected, "Failed to load Manage News page after login.");
		    
		managenewspage.clicknewbutton().enternewtextarea().clicksavebutton();
		
		
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
			//String actualMessage = successMsg.getText();
			//String expectedMessage = "News created successfully";
			//System.out.println("Success Message: " + actualMessage);
			//Assert.assertEquals(actualMessage, expectedMessage, "News creation message mismatch!");// the code will be diff if we open in new tab .
			//this is for opening in same tab.
		
		
	}
	@Test(description = "searching  added new manage news in the list")
	public void verifythenewnews() throws IOException
	{
		HomePage homepage;
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username).enterpasswordonpasswordfield(password);
		homepage=loginpage.clicksubmitbutton();
		
		ManagenewsPages managenewspage;
		managenewspage=homepage.clickOnManageNewsTab();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Manage News')]")));
	    
	    String actual = managenewspage.getManageNewsHeaderText();
	    String expected = "Manage News";
	    Assert.assertEquals(actual, expected, "Failed to load Manage News page after login.");
	    
	    managenewspage.clicksearchbutton().entersearchtextarea().clicktextareasearchbutton();
	    
	    
	}
	
	
	
	
	

}
