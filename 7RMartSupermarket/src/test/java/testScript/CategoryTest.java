package testScript;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
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
	    Assert.assertEquals(actual, expected, "Failed to load category page after login.");
	    
	    category.clicknewCategoryButton();
		category.entercategoryInputField("Supermarket category");
		category.clickselectgroups();
		category.uploadMainImage("C:\\Users\\Bincy\\Downloads\\1filr9D-pokemon-wallpapers (1).jpg");
		category.clicksaveButton();
		
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[i[contains(@class, 'fa-check')]]")));
		String actualMessage = successMsg.getText();
		String expectedMessage = "News created successfully";
		System.out.println("Success Message: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "News creation message mismatch!");
		
	}

}
