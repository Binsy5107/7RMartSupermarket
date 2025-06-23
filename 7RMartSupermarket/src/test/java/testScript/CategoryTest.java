package testScript;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.CategoryPages;
import pages.LoginPages;
import utilities.ExcelUtility;

public class CategoryTest extends Base{
	@Test(description = "adding new category to catgory list")
	public void verifyabletocreatenewcategory() throws IOException, AWTException 
	{
		String username=ExcelUtility.getStringData(0, 0, "Loginpages");
		String password=ExcelUtility.getStringData(0, 1, "Loginpages");
		LoginPages loginpage=new LoginPages(driver);
		loginpage.enterusernameonusernamefield(username);
		loginpage.enterpasswordonpasswordfield(password);
		loginpage.clicksubmitbutton();
		
		CategoryPages category=new CategoryPages(driver);
		category.clickmoreInfoLink();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'List Categories')]")));
	    
	    
	    String actual = category.getCategoryHeaderText();
	    String expected = "List Categories";
	    Assert.assertEquals(actual, expected,  Messages.CATEGORYPAGELOAD);
	    
	    category.clicknewCategoryButton().entercategoryInputField().uploadMainImage().clicksaveButton();
		
		
	}
	
		
	

}
