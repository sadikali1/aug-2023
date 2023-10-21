package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SeleniumExample {
	
	// selenium 4.6 
	
	// chromedriver.exe
	// edgedriver.exe
	// gecodriver.exe
	
	@Test
	public void testExample() {
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		int a = 10;
		///InternetExplorerDriver 
		//SafariDriver 
	
		driver.get("https://www.facebook.com");
		WebElement element = driver.findElement(By.id("email"));
		element.clear();
		element.sendKeys("test@gmail.com");
		
		WebElement element1 =  driver.findElement(By.id("pass"));
		element1.sendKeys("Password");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@data-testid='royal_login_button']"));
		loginButton.click();
		
		//driver.quit();
	}
}


// Locator

// element 

// Id
// name
// xpath  or CSS
// link
// partial link
// tag name
// class name

