package com.selenium.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Windowhandle {

	@Test
	public void windHandle() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("tabButton")).click();
		String parentWinId = driver.getWindowHandle();
		
		Set<String> currentWinIds = driver.getWindowHandles();
		
		for(String winId : currentWinIds) {
			driver.switchTo().window(winId);
		}
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		driver.close();
		driver.switchTo().window(parentWinId);
		driver.findElement(By.id("windowButton")).click();
	}
}
