
//File risulta attualmente aggiornato per webdriver chrome headless!
package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHooks {
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
  public void testHooks() throws Exception {
    driver.get("http://localhost:4200/auth");
    driver.findElement(By.xpath("//*[@x184761162527-x-test-tpl-1]//*[@x184761162527-x-test-hook-9]//*[@x184690670675-x-test-tpl-2]//*[@x184690670675-x-test-hook-4]//*[@x184733771964-x-test-tpl-1]//*[@x184733771964-x-test-hook-8]")).click();
    driver.findElement(By.xpath("//*[@x184761162527-x-test-tpl-1]//*[@x184761162527-x-test-hook-9]//*[@x184690670675-x-test-tpl-2]//*[@x184690670675-x-test-hook-4]//*[@x184733771964-x-test-tpl-1]//*[@x184733771964-x-test-hook-8]")).clear();
    driver.findElement(By.xpath("//*[@x184761162527-x-test-tpl-1]//*[@x184761162527-x-test-hook-9]//*[@x184690670675-x-test-tpl-2]//*[@x184690670675-x-test-hook-4]//*[@x184733771964-x-test-tpl-1]//*[@x184733771964-x-test-hook-8]")).sendKeys("test@test.com");
    driver.findElement(By.xpath("//*[@x184761162527-x-test-tpl-1]//*[@x184761162527-x-test-hook-9]//*[@x184690670675-x-test-tpl-2]//*[@x184690670675-x-test-hook-4]//*[@x184733771964-x-test-tpl-1]//*[@x184733771964-x-test-hook-11]")).clear();
    driver.findElement(By.xpath("//*[@x184761162527-x-test-tpl-1]//*[@x184761162527-x-test-hook-9]//*[@x184690670675-x-test-tpl-2]//*[@x184690670675-x-test-hook-4]//*[@x184733771964-x-test-tpl-1]//*[@x184733771964-x-test-hook-11]")).sendKeys("test123");
    driver.findElement(By.xpath("//*[@x184761162527-x-test-tpl-1]//*[@x184761162527-x-test-hook-9]//*[@x184690670675-x-test-tpl-2]//*[@x184690670675-x-test-hook-4]//*[@x184733771964-x-test-tpl-1]//*[@x184733771964-x-test-hook-13]")).click();
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
