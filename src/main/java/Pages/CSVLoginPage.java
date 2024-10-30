package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSVLoginPage {
	WebDriver driver;
	
	@FindBy(id = "username")
	WebElement usernameField;
	public WebElement getusernameField() {
		return usernameField;
	}
	
	@FindBy(id = "password")
	WebElement passwordField;
	public WebElement getpasswordField() {
		return passwordField;
	}
	
	@FindBy(id= "submit")
	WebElement loginBtn; 
	public WebElement getloginBtn() {
		return loginBtn;
	}
	
	@FindBy(xpath = "//*[@id='error']")
	WebElement loginMgs;
	public WebElement getloginMgs() {
		return loginMgs;
	}
	
	@FindBy(xpath = "//*[@id='loop-container']/div/article/div[1]/h1")
	WebElement SuccessMgs;
	public WebElement getSuccessMgs() {
		return SuccessMgs;
	}
	
	
	
	public CSVLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


}
