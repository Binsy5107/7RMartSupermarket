package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	

	
	
	public void clickmoreInfoLink()
	{
		moreInfoLink.click();
	}
	
	public String getCategoryHeaderText() {
	    return listCategoriesHeader.getText();
	}
	public void clicknewCategoryButton()
	{
		newCategoryButton.click();
	}
	public void entercategoryInputField(String categoryname)
	{
		categoryInputField.sendKeys(categoryname);
	}
	
	public void clickselectgroups()
	{
		selectgroups.click();
	}
	public void uploadMainImage(String filePath) 
	{
		uploadMainImage.sendKeys(filePath);
	}
	
	public void clicksaveButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
	    
	    try {
	        Thread.sleep(500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    saveButton.click();
	}

}
