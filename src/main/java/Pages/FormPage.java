package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1[@class='text-center']")
	WebElement formTitle;
	public WebElement getformTitle() {
		return formTitle;
	}
	
	@FindBy(css = "input[id='firstName']")
	WebElement firstNameField;
	public WebElement getfirstNameField() {
		return firstNameField;
	}
	
	@FindBy(css = "input[id='lastName']")
	WebElement lastNameField;
	public WebElement getlastNameField() {
		return lastNameField;
	}
	
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement emailField;
	public WebElement getemailField() {
		return emailField;
	}
	
	@FindBy(xpath = "//*[@id='genterWrapper']/div[2]/div[2]/label")
	WebElement genderRdBtn;
	public WebElement getgenderRdBtn() {
		return genderRdBtn;
	}
	
	@FindBy(css = "input[id='userNumber']")
	WebElement userNumber;
	public WebElement getuserNumber() {
		return userNumber;
	}
	
	@FindBy(xpath = "//*[@id='dateOfBirthInput']")
	WebElement DOBField;
	public WebElement getDOBField() {
		return DOBField;
	}
	
	@FindBy(xpath = "//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]")
	WebElement selectDOB;
	public WebElement getselectDOB() {
		return selectDOB;
	}
	
	
	@FindBy(xpath = "//input[@id='subjectsInput']")
	WebElement subjectsInput;
	public WebElement getsubjectsInput() {
		return subjectsInput;
	}
	
	@FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[1]/label")
	WebElement hobbiesBtn;
	public WebElement gethobbiesBtn() {
		return hobbiesBtn;
	}
	
	public FormPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
