package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.TestLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginStepDef {
	WebDriver driver;
	TestLoginPage testlogPg;
	WebDriverWait wait;
	JavascriptExecutor js;

	@Given("the browser is launched")
	public void the_browser_is_launched() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("the user is on Test Login Page")
	public void the_user_is_on_test_login_page() {
		testlogPg = new TestLoginPage(driver);
		driver.get("https://practicetestautomation.com/practice-test-login/");
		String LoginTitle = testlogPg.getLoginPageTitle().getText();
		Assert.assertEquals(LoginTitle, "Test login");
		System.out.println("***The user is on " + LoginTitle + "***");
	}

//	Positive credentials
	@Given("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws InterruptedException {
		testlogPg.getusernameField().sendKeys("student");
		testlogPg.getpasswordField().sendKeys("Password123");
		Thread.sleep(3000);

	}

	@And("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		testlogPg.getsubmitBtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)","");

	}

	@Then("verify user lands on sucessful login message page")
	public void verify_user_lands_on_sucessful_login_message_page() {
		String loginMgsTitle = driver.getCurrentUrl();
		Assert.assertTrue(loginMgsTitle.contains("practicetestautomation.com/logged-in-successfully/"));

	}

	@Then("the page should contain the successful login message")
	public void the_page_should_contain_the_successful_login_message() {
		String loginMgs = testlogPg.getsuccessLoginMgs().getText();
		Assert.assertTrue(loginMgs.contains("Congratulations") || loginMgs.contains("successfully logged in"));
		System.out.println("Mgs displayed: " + loginMgs);

	}

	@Then("verify the Log out button should be displayed on the sucessful login message page")
	public void verify_the_log_out_button_should_be_displayed_on_the_sucessful_login_message_page()throws InterruptedException {
		Thread.sleep(3000);
		testlogPg.getlogOutBtn().click();

	}

//	Negative Credentials
	@Given("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String string, String string2) throws InterruptedException {
		testlogPg.getusernameField().sendKeys(string);
		testlogPg.getpasswordField().sendKeys(string2);
		Thread.sleep(3000);

	}

	@And("Verify error message is displayed")
	public void verify_error_message_is_displayed() throws InterruptedException {
		WebElement errorBanner=  testlogPg.geterrorBanner();
		wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(errorBanner));
		boolean errorBannerMgs = errorBanner.isDisplayed();
		Assert.assertTrue(errorBannerMgs);

	}

	@Then("Verify error message text is {string}")
	public void verify_error_message_text_is(String string) throws InterruptedException {
		String errorMgs = testlogPg.geterrorBanner().getText();
		String usernameFound = testlogPg.getusernameField().getAttribute("value");
		String passwordFound = testlogPg.getpasswordField().getAttribute("value");
		if (!usernameFound.equals("student") && !usernameFound.isEmpty()) {
			Assert.assertEquals(errorMgs, "Your username is invalid!");
		} else if (!passwordFound.equals("Password123") && !passwordFound.isEmpty()) {
			Assert.assertEquals(errorMgs, "Your password is invalid!");
		}
		Thread.sleep(3000);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
