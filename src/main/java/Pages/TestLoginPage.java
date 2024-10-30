package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h2[text()='Test login']")
	WebElement LoginPageTitle;
	public WebElement getLoginPageTitle() {
		return LoginPageTitle;
	}
	
	@FindBy(css = "input#username")
	WebElement usernameField;
	public WebElement getusernameField() {
		return usernameField;
	}
	
	@FindBy(id = "password")
	WebElement passwordField;
	public WebElement getpasswordField() {
		return passwordField;
	}
	
	@FindBy(css = "button#submit")
	WebElement submitBtn;
	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(tagName = "strong")
	WebElement successLoginMgs;
	public WebElement getsuccessLoginMgs() {
		return successLoginMgs;
	}
	
	@FindBy(linkText = "Log out")
	WebElement logOutBtn;
	public WebElement getlogOutBtn() {
		return logOutBtn;
	}
	
	@FindBy(css = "div.show")
	WebElement errorBanner;
	public WebElement geterrorBanner() {
		return errorBanner;
	}
	
	
	
	public TestLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
