package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowScroll {

	@Test
	public void windScroll() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(1000, 1000)");
		
		WebElement element = driver.findElement(By.id("downloadButton"));
		js.executeScript("arguments[0].click()", element);
		
		//js.executeScript("document.getElementById(\"downloadButton\").click()");
	}
}
