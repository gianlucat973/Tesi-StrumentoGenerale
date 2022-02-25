
//File risulta attualmente aggiornato per webdriver chrome headless!
package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
  public void testHooks_loc_Hooks_release_1_0() throws Exception {
    driver.get("http://localhost:4200/");
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-10]")).click();
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-10]")).clear();
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-10]")).sendKeys("Mario");
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-11]")).click();
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-13]")).clear();
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-13]")).sendKeys("Rossi");
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-17]")).click();
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-17]")).clear();
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-17]")).sendKeys("mario.rossi@email.com");
    driver.findElement(By.xpath("//*[@x230953393589-x-test-tpl-1]//*[@x230953393589-x-test-hook-9]//*[@x230938714303-x-test-tpl-2]//*[@x230938714303-x-test-hook-18]")).click();
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
