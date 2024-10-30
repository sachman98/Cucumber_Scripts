package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;	
	
	@FindBy(id = "login2")
	WebElement SignInBtn;
	public WebElement getSignInBtn() {
		return SignInBtn;
	}

	@FindBy(id = "loginusername")
	WebElement UserNameField;
	public WebElement getUserNameField() {
		return UserNameField;
	}

	@FindBy(id = "loginpassword")
	WebElement PasswordField;
	public WebElement getPasswordField() {
		return PasswordField;
	}

	@FindBy(xpath = "//*[@id='logInModal']/div/div/div[3]/button[2]")
	WebElement LoginBtn;
	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	@FindBy(id = "nameofuser")
	WebElement NameOfUser;
	public WebElement getNameOfUser() {
		return NameOfUser;
	}

	@FindBy(id = "logout2")
	WebElement LogoutBtn;
	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
