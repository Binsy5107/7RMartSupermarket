package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagenewsPages {
	public WebDriver driver;
	public ManagenewsPages(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(xpath = "//input[@name='username']")private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")private WebElement  submitbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']")private WebElement managenews;
	@FindBy(xpath = "//h1[contains(text(), 'Manage News')]")private WebElement manageNewsHeader;
	@FindBy(css = ".btn.btn-rounded.btn-danger")private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")private WebElement newsTextArea;
	@FindBy(xpath = "//button[text()='Save']")private WebElement savebutton;
	@FindBy(css = "a.btn.btn-rounded.btn-primary[onclick='click_button(2)']")private WebElement searchbutton;
	@FindBy(css="input.form-control[name='un'][placeholder='Title']")private WebElement searchtextarea;
	@FindBy(xpath = "//button[@name='Search' and @type='submit']")private WebElement textareasearchbutton;
	
	
	
	
	public void clickmanagenews() 
	{
		managenews.click();
	}
	
	public String getManageNewsHeaderText() {
	    return manageNewsHeader.getText();
	}
	public void clicknewbutton()
	{
		newbutton.click();
	}
	public void enternewtextarea()
	{
		newsTextArea.sendKeys("supermarket news");
	}
	public void clicksavebutton()
	{
		savebutton.click();
	}
	public void clicksearchbutton()
	{
		searchbutton.click();
	}
	public void entersearchtextarea()
	{
		searchtextarea.sendKeys("supermarket news");
	}
	public void clicktextareasearchbutton() 
	{
		textareasearchbutton.click();
	}

}
