package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {

	@Test
	public void testMouseHover() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Main Item 2']")))
			.pause(1000).moveToElement(driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']")))
			.pause(1000).click(driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"))).build().perform();
	}
}


// within 5 seconds not remaining 25 second
// stop 30 second 
