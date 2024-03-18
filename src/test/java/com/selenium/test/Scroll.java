package com.selenium.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.selenium.utility.ChromeDriverUtility;

public class Scroll {

	@Test
 public void scrollDowntest() throws InterruptedException {
	 WebDriver driver;
	 ChromeDriverUtility driverUtility=new ChromeDriverUtility();
	 driver=driverUtility.initChromeDriver();
	 
	 driver.get("https://qavalidation.com/demo-form/");
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	 driver.manage().window().maximize();
	 
	 //Scroll Method 1 - using JavaScriptExecutor
	 JavascriptExecutor js= (JavascriptExecutor) driver;
	 
	 //using x,y offset
	 js.executeScript("window.scrollBy(0,350)");
	 Thread.sleep(2000);
	 
	 //using webElement
	 WebElement element1=driver.findElement(By.xpath("//a[@href='http://qavalidation.com/protractor-tutorial/' and text()=' Protractor with TS']"));
	 js.executeScript("arguments[0].scrollIntoView(true);",element1);
	 
	 
	 //to scroll to bottom of the page using height in y offset
	 //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	 
	 
	 //Scroll using Action Class moveToElement Method
	 
	 Thread.sleep(2000);
	 driverUtility.tearDown();
 }
}
