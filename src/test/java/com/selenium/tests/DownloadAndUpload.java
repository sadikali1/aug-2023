package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DownloadAndUpload {

	@Test
	public void testUploadDownload() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("downloadButton")).click();
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\admin\\Downloads\\sampleFile.jpeg");
	}
}
