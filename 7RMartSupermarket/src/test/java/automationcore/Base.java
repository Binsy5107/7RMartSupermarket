package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;

public class Base {
	Properties prop;//For reading config values (not used here, but may be used elsewhere)
	FileInputStream file;//To load a file stream (not used here).
	public static WebDriver driver;//Static WebDriver instance used by all tests

	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void intializeBrowser(String browsers) throws Exception
	{
		if(browsers.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if (browsers.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
			throw new Exception("invalid browser");
		 
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait--Duration is a class
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)//iTestResult--interface . // Check if the test failed
	{
	ScreenShotUtility screenShot=new ScreenShotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName());// Capture screenshot
	}
	driver.quit();

	}

}
