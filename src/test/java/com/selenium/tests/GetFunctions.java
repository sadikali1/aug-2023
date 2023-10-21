package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetFunctions {

	@Test
	public void getElementExample() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String text = driver.findElement(By.className("_8eso")).getText();
		System.out.println(text);
		Assert.assertEquals("Facebook helps you connect and share with the people in your life.", text);
		
		String placeholder = driver.findElement(By.id("email")).getAttribute("placeholder");
		System.out.println(placeholder);
		Assert.assertEquals(placeholder, "Email address or phone number");
		
		String fontSize = driver.findElement(By.name("login")).getCssValue("font-size");
		String borderRadius = driver.findElement(By.name("login")).getCssValue("border-radius");
		String width = driver.findElement(By.name("login")).getCssValue("width");
		System.out.println(fontSize);
		System.out.println(borderRadius);
		System.out.println(width);
		
	}
	
	@Test
	public void getDriverExample() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String title = driver.getTitle();
		System.out.println(title);
	
		driver.findElement(By.linkText("Forgotten password?")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("ctx=recover"));
		
		System.out.println(driver.getPageSource());
	}
}
