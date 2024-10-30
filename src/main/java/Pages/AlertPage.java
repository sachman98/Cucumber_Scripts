package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
	
WebDriver driver;
	
	@FindBy(xpath = "//h1[contains(@class, 'text-')]")
	WebElement heading;
	public WebElement getheading() {
		return heading;
	}
	
	@FindBy(xpath = "//button[starts-with(@id, 'confirmButton')]")
	WebElement clickBtn;
	public WebElement getclickBtn() {
		return clickBtn;
	}
	
	@FindBy(xpath = "//span[contains(text(), 'You selected')]")
	WebElement clickMgs;
	public WebElement getclickMgs() {
		return clickMgs;
	}
	public AlertPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
