package StepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Pages.AlertPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertStepDef {
	WebDriver driver = null;
	AlertPage alPg;
	JavascriptExecutor js;

	@Given("the web browser is launched")
	public void the_web_browser_is_launched() {
		String browser = "edge";

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser could not be invoked");
		}
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

	}

	@Given("the user is landed on the website")
	public void the_user_is_landed_on_the_website() {
		alPg = new AlertPage(driver);
		String heading = alPg.getheading().getText();
		System.out.println(heading);
		Assert.assertEquals(heading, "Alerts");
	}

	@And("the user enters clicks on the alert button")
	public void the_user_enters_clicks_on_the_alert_button() throws InterruptedException   {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		alPg.getclickBtn().click();
		Thread.sleep(3000);

	}

	@Then("user handles the alert box")
	public void user_handles_the_alert_box() throws InterruptedException {
		driver.switchTo().alert().dismiss();
		String alertMgs = alPg.getclickBtn().getText();
		Thread.sleep(3000);
		System.out.println("***" + alertMgs + "***");

	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
