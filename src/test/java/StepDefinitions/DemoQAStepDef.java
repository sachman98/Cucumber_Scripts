package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.FormPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQAStepDef {
	ChromeDriver driver;
	JavascriptExecutor js;
	FormPage fp;

	@Given("the environment setup is completed")
	public void the_environment_setup_is_completed() {
		System.out.println("**The setup is Completed");

	}

	@When("the user launches the web browsers")
	public void the_user_launches_the_web_browsers() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Then("the navigates to the given link")
	public void the_navigates_to_the_given_link() {
		driver.get("https://demoqa.com/automation-practice-form");

	}

	@Given("the user is on the landing page")
	public void the_user_is_on_the_landing_page() {
		fp=new FormPage(driver);
		String formTitle = fp.getformTitle().getText();
		Assert.assertEquals(formTitle, "Practice Form");
		System.out.println("**User has successfully landed on DemoQA page**");
	}

	@Given("user enters {string} in firstname field and {string} in lastname field")
	public void user_enters_in_firstname_field_and_in_lastname_field(String firstName, String lastName) {
		fp.getfirstNameField().sendKeys(firstName);
		fp.getlastNameField().sendKeys(lastName);
	}

	@Given("user enters the email {string} in email field")
	public void user_enters_the_email_in_email_field(String emailID) {
		fp.getemailField().sendKeys(emailID);
	}

	@Given("clicks on gender radio button")
	public void clicks_on_gender_radio_button() throws InterruptedException {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		fp.getgenderRdBtn().click();

	}

	@Given("enters the mobile number {string}")
	public void enters_the_mobile_number(String userNumber) {
		fp.getuserNumber().sendKeys(userNumber);

	}

	@Given("select the date of birth")
	public void select_the_date_of_birth() {
		fp.getDOBField().click();
		fp.getselectDOB().click();
		

	}

	@Given("enter subjects in subjects field")
	public void enter_subjects_in_subjects_field() {
		WebElement subjectInput=fp.getsubjectsInput();
		subjectInput.click();
		subjectInput.sendKeys("maths");
		subjectInput.sendKeys(Keys.ENTER);

	}

	@Given("clicks on checkbox for hobbies")
	public void clicks_on_checkbox_for_hobbies() {
		fp.gethobbiesBtn().click();

	}

//	@Given("uploads a file from local drive")
//	public void uploads_a_file_from_local_drive() {
//		driver.findElement(By.id("uploadPicture")).click();
//		driver.findElement(By.id("uploadPicture")).sendKeys(Keys.ESCAPE);
//		
//	}
//
//	@Then("validates the file has been uploaded")
//	public void validates_the_file_has_been_uploaded() {
//
//	}

	@Then("user enters address in address field")
	public void user_enters_address_in_address_field() {
		driver.findElement(By.cssSelector("textarea[placeholder*='Current Address']")).sendKeys("Current address field is accessible");

	}

	@Then("user selects state from dropdown")
	public void user_selects_state_from_dropdown() throws InterruptedException {
		driver.findElement(By.cssSelector("div[class*='css-2b097c-container']")).click();
		Thread.sleep(3000);

	}

//	@Then("validates city dropdrown")
//	public void validates_city_dropdrown() {
//
//	}

	@Then("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("submit")).sendKeys(Keys.ESCAPE);

	}

//	@Then("validates the form review page is displayed")
//	public void validates_the_form_review_page_is_displayed() throws InterruptedException {
//		WebElement iframe=driver.findElement(By.tagName("iframe"));
//		Thread.sleep(3000);
//		driver.switchTo().frame(iframe);
//		String submitConfirm=driver.findElement(By.xpath("//*[@id='example-modal-sizes-title-lg']")).getText();
//		System.out.println(submitConfirm);
//	}
	
	@Then("the browsers is closed")
	public void the_browsers_is_closed() {
	    driver.close();
	}

}
