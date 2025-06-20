package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.constant;

public class CategoryPages {
	public WebDriver driver;
	public CategoryPages(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and contains(@class, 'small-box-footer')]")private WebElement moreInfoLink;
	@FindBy(xpath = "//h1[contains(text(),'List Categories')]")private WebElement listCategoriesHeader;
	@FindBy(xpath = "//a[contains(@class, 'btn-rounded') and contains(@onclick, 'click_button(1)')]")private WebElement newCategoryButton;
	@FindBy(xpath = "//input[@id='category']")private WebElement categoryInputField;
	@FindBy(css = "li.ms-elem-selectable > span")private WebElement selectgroups;
	@FindBy(css = "input#main_img")private WebElement uploadMainImage;
	@FindBy(xpath = "//button[@class='btn btn-danger']")private WebElement saveButton;
	
		
	public CategoryPages clickmoreInfoLink()
	{
		moreInfoLink.click();
		return this;
	}
	
	public String getCategoryHeaderText() {
	    return listCategoriesHeader.getText();
	}
	public CategoryPages clicknewCategoryButton()
	{
		newCategoryButton.click();
		return this;
	}
	public CategoryPages entercategoryInputField()
	{
		categoryInputField.sendKeys(constant.NEWCATEGORYNAME);
		return this;
	}
	
	public CategoryPages clickselectgroups()
	{
		selectgroups.click();
		return this;
	}
	public CategoryPages uploadMainImage() 
	{
		uploadMainImage.sendKeys(constant.TESTIMAGEFILE);
		return this;
	}
	
	public void clicksaveButton()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the button is visible and enabled
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));

	    // Scroll to the button
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", saveButton);

	    // Click using JavaScript to avoid interception
	    js.executeScript("arguments[0].click();", saveButton);

	}

	
		
		
	


}
