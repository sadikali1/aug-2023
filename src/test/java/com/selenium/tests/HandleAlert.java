package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAlert {

	@Test
	public void testHandleAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("alertButton")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		/*
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept(); */
		
		WebElement element = driver.findElement(By.id("confirmButton"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		element.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
		driver.findElement(By.id("promtButton")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Testing");
		alert3.accept();
	}
}
