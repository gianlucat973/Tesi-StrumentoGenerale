
//File risulta attualmente aggiornato per webdriver chrome headless!
package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestTradizionale3 {
private static WebDriver driver;
private boolean acceptNextAlert = true;
private static StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		
		  // Init chromedriver
		  String chromeDriverPath = "/home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/chromedriver_v94_linux64/chromedriver";
		  System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		  System.setProperty("webdriver.chrome.whitelistedIps", "");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--no-sandbox","--ignore-certificate-errors");
		  driver = new ChromeDriver(options);  
		  
		  
		  
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void testTradizionale_release_1_2() throws Exception {
    driver.get("http://localhost:4200/");
    driver.findElement(By.id("exampleInputPassword1")).click();
    driver.findElement(By.id("exampleInputPassword1")).clear();
    driver.findElement(By.id("exampleInputPassword1")).sendKeys("Perretta");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create User'])[1]/following::form[1]")).click();
  }


 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
