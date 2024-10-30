package StepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.CSVLoginPage;
import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSVStepDef {
	WebDriver driver;
	CSVLoginPage login;
	JavascriptExecutor js;
	CSVReader reader;
	String filePath;
	String[] line;
	ConfigFileReader configFileReader;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		configFileReader = new ConfigFileReader();
		driver.get(configFileReader.getApplicationUrl());
	}

	@Given("the user has launched the web browser")
	public void the_user_has_launched_the_web_browser() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, configFileReader.getApplicationUrl());
	}

	@Given("the user in the login page")
	public void the_user_in_the_login_page() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Test Login | Practice Test Automation");
	}

	@When("user reads data from csv")
	public void user_reads_data_from_csv() throws InterruptedException, CsvValidationException, IOException {
//		filePath = "C:/Users/Sachit/eclipse-workspace/Demo/src/test/resources/TestData/csvlogin.csv";
		reader = new CSVReader(new FileReader(configFileReader.getCSVPath()));
	}


	@Then("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException, CsvValidationException, IOException {
		while ((line = reader.readNext()) != null) {
			if (line.length > 0) {
				for (int i = 0; i < 1; i++) {
					String username1 = line[i];
					String password1 = line[i + 1];
					login = new CSVLoginPage(driver);
					login.getusernameField().sendKeys(username1);
					login.getpasswordField().sendKeys(password1);
					login.getloginBtn().click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
					String status = driver.getCurrentUrl();
					System.out.println(status);
					if (status.contains("https://practicetestautomation.com/logged-in-successfully/")) {
						System.out.println("Login Successful");
						Assert.assertEquals(status, "https://practicetestautomation.com/logged-in-successfully/");
					} else {
						System.out.println("Login Unsuccessful");
					}
					driver.navigate().back();

				}

			}
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}