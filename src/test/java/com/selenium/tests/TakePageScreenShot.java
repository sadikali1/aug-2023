package com.selenium.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakePageScreenShot {
	
	@Test
	public void takeScreenPage() throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File file1 = tk.getScreenshotAs(OutputType.FILE);
		File file2 = new File("screen.png");
		FileUtils.copyFile(file1, file2);
	}

	@Test
	public void takeScreenElement() throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.name("login"));
		//TakesScreenshot tk = (TakesScreenshot)driver;
		File file1 = element.getScreenshotAs(OutputType.FILE);
		File file2 = new File("button.png");
		FileUtils.copyFile(file1, file2);
	}
}
