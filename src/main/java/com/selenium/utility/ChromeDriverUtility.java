package com.selenium.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverUtility {
	public static WebDriver chromeDriver;
	
	public WebDriver initChromeDriver() {
		
		WebDriverManager.chromedriver().setup();
		chromeDriver = new ChromeDriver();
		//chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return chromeDriver;
	}
	
	public void tearDown(){
		chromeDriver.quit();
		
	}
}
