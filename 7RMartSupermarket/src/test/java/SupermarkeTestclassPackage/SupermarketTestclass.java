package SupermarkeTestclassPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import Packagesupermarker.BaseSupermarker;
import SupermarketPageclassPackage.SupermarketPageclass;
import SupermarketUtilities.SupermarketExcelUtility;

public class SupermarketTestclass extends BaseSupermarker {
	
	@Test
	public void veriyUserLoginWithValidCredentials() throws IOException
	{
		String username=SupermarketExcelUtility.getStringData(0, 0, "Loginpages");
		String password=SupermarketExcelUtility.getStringData(0, 0, "Loginpages");
		SupermarketPageclass Supermarket=new SupermarketPageclass(driver);
		Supermarket.enterusernameonusernamefield(username);
		Supermarket.enterpasswordonpasswordfield(password);
		Supermarket.clicksubmitbutton();
	}
	
	@Test
	public void verifyuserloginwithinvalidusername() throws IOException
	{
		String username=SupermarketExcelUtility.getStringData(1, 0, "Loginpages");
		String password=SupermarketExcelUtility.getStringData(1, 1, "Loginpages");
		SupermarketPageclass Supermarket=new SupermarketPageclass(driver);
		Supermarket.enterusernameonusernamefield(username);
		Supermarket.enterpasswordonpasswordfield(password);
		Supermarket.clicksubmitbutton();
	}
	
	@Test
	public void verifyuserloginwithinvalidpassword() throws IOException 
	{
		String username=SupermarketExcelUtility.getStringData(2, 0, "Loginpages");
		String password=SupermarketExcelUtility.getStringData(2, 1, "Loginpages");
		SupermarketPageclass Supermarket=new SupermarketPageclass(driver);
		Supermarket.enterusernameonusernamefield(username);
		Supermarket.enterpasswordonpasswordfield(password);
		Supermarket.clicksubmitbutton();
	}
	
	@Test
	public void verifyuserloginwithinvalidcredential() throws IOException
	{
		String username=SupermarketExcelUtility.getStringData(3, 0, "Loginpages");
		String password=SupermarketExcelUtility.getStringData(3, 1, "Loginpages");
		SupermarketPageclass Supermarket=new SupermarketPageclass(driver);
		Supermarket.enterusernameonusernamefield(username);
		Supermarket.enterpasswordonpasswordfield(password);
		Supermarket.clicksubmitbutton();
	}
	
}
