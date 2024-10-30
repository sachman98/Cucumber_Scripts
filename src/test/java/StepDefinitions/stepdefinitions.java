package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefinitions {

	WebDriver driver;
	LoginPage lp;

	@Given("the setup is completed")
	public void the_setup_is_completed() {
		System.out.println("The setup is initiated");

	}

	@When("the user launches the browsers")
	public void the_user_launches_the_browsers() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Then("the navigates to the link")
	public void the_navigates_to_the_link() {
		driver.get("https://www.demoblaze.com/");

	}

	@Given("the user is landed in the landing page")
	public void the_user_is_landed_in_the_landing_page() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title.contains("STORE"), true);
	}

	@When("the user login into the application with username {string} and password {string}")
	public void the_user_login_into_the_application_with_username_and_password(String string, String string2)
			throws InterruptedException {
		lp = new LoginPage(driver);
		lp.getSignInBtn().click();
		Thread.sleep(3000);
		lp.getUserNameField().sendKeys(string);
		lp.getPasswordField().sendKeys(string2);
		lp.getLoginBtn().click();
		System.out.println("The user has successfully logged in with credentials ");
	}

	@Then("validate the username is displayed")
	public void validate_the_home_page_is_displayed() throws InterruptedException {
		Thread.sleep(3000);
		String username = lp.getNameOfUser().getText();
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle, "STORE");
		System.out.println("The username is displayed : " + username);

	}

	@Then("the user is logged out")
	public void the_title_is_displayed() {
		lp.getLogoutBtn().click();
		System.out.println("The user has logged out Successfully");
	}

}
