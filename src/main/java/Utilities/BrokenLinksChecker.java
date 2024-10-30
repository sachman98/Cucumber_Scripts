package Utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksChecker {

	public static void main(String arg[]) {
		String browser = "firefox";
		WebDriver driver = null;

// Initial different web browser
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
		driver.get("https://www.guru99.com/using-contains-sbiling-ancestor-to-find-element-in-selenium.html");
		
// Fetch all the links in the site
		System.out.println(driver.findElements(By.tagName("a")).size());
		List<WebElement> links = driver.findElements(By.tagName("a"));		
		for (WebElement link : links) {
			String urls = link.getAttribute("href");
			checkURL(urls);
		}
	}
//	Establish connection using the URLS
	public static void checkURL(String urls) {
		try {
			URL link = new URL(urls);
			HttpURLConnection httpconnection = (HttpURLConnection) link.openConnection();
			httpconnection.setConnectTimeout(3000);
			httpconnection.connect();

			if (httpconnection.getResponseCode() >= 400) {
				System.out.println(urls + " ----> " + "is a broken link");
			} else {
				System.out.println(urls + " ----> " + httpconnection.getResponseCode());
			}
		} catch (Exception e) {
			System.out.println(urls + " - " + "is a broken link");
		}
	}
}
