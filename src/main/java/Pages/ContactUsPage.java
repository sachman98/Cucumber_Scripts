package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	WebDriver driver;
	
	@FindBy(css = "input[name='name']")
	WebElement username;
	public WebElement getusername() {
		return username;
	}
	
	@FindBy(css = "input[name='email']")
	WebElement email;
	public WebElement getemail() {
		return email;
	}
	
	@FindBy(css = "input[name='subject']")
	WebElement subject;
	public WebElement getsubject() {
		return subject;
	}
	
	
	@FindBy(id="message")
	WebElement messageField;
	public WebElement getmessageField() {
		return messageField;
	}
			
	@FindBy(name = "submit")
	WebElement submitBtn;
	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//*[@id='contact-page']/div[2]/div[1]/div/div[2]")
	WebElement SuccessMgs;
	public WebElement getSuccessMgs() {
		return SuccessMgs;
	}
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
