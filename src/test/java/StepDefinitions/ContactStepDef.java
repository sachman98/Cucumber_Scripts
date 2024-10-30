package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.ContactUsPage;
import Utilities.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactStepDef {
	WebDriver driver;
	ContactUsPage contact;
	ExcelReader excelreader;
	JavascriptExecutor js;

	@Given("the user navigates to the contact page")
	public void the_user_navigates_to_the_contact_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/contact_us");
		driver.manage().window().maximize();

	}

	@When("the user fills the form from the given sheetname {string} and rownumber {int}")
	public void the_user_fills_the_form_from_the_given_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {
		excelreader = new ExcelReader();
		List<Map<String, String>> testData = excelreader.getData("C:\\Users\\Sachit\\eclipse-workspace\\Demo\\src\\test\\resources\\TestData\\logindata.xlsx",
				sheetname);
		String username = testData.get(rownumber).get("username");
		String email = testData.get(rownumber).get("email");
		String subject = testData.get(rownumber).get("subject");
		String message = testData.get(rownumber).get("message");

		contact = new ContactUsPage(driver);
		contact.getusername().sendKeys(username);
		contact.getemail().sendKeys(email);
		contact.getsubject().sendKeys(subject);
		contact.getmessageField().sendKeys(message);

	}

	@When("the user clicks on submit button")
	public void the_user_clicks_on_submit_button() {
		js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		contact.getsubmitBtn().click();

	}

	@Then("verify the message {string} is displayed")
	public void verify_the_message_is_displayed(String string) {
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String successMgs = contact.getSuccessMgs().getText();
		Assert.assertEquals(successMgs, "Success! Your details have been submitted successfully.");

	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}