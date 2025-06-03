package Packagesupermarker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSupermarker {
	
	public static WebDriver driver;
	@BeforeMethod
	public void intializeBrowser()
	{
		 driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		//driver.quit();
	}

}
