package com.example.SeleniumJenkins;

import org.testng.annotations.Test;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNGTest {

	public static final String USERNAME = "skirankumars";
	public static final String ACCESS_KEY = "aed6d35f-ec8d-4f82-a641-4a095e32abf0";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	private WebDriver driver;
	Eyes eyes = new Eyes();

	@Test
	public void f() {
		driver = eyes.open(driver, "Applitools", "Test Applitools with Selenium", new RectangleSize(1024, 768));
		driver.get("http://www.guru99.com/selenium-tutorial.html");
		String title = driver.getTitle();
		eyes.checkWindow("Free Selenium Tutorials");
		AssertJUnit.assertTrue(title.contains("Free Selenium Tutorials"));
		eyes.close();
	}

	@BeforeTest
	public void beforeTest() {
		// This is your api key, make sure you use it in all your tests.
		eyes.setApiKey("YNciQrgazqvTusy2k99Zf2u8YIBp2lZngPVqxCWQYtCs110");
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "42");
		try {
			 driver = new RemoteWebDriver(new URL(URL),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
