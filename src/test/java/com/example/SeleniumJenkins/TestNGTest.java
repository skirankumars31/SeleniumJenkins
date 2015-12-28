package com.example.SeleniumJenkins;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNGTest {
	
	private WebDriver driver;
	
  @Test
  public void f() {
	  driver.get("http://www.guru99.com/selenium-tutorial.html");  
      String title = driver.getTitle();                
      AssertJUnit.assertTrue(title.contains("Free Selenium Tutorials"));
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();  
  }

}
