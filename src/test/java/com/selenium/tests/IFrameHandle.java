package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IFrameHandle {

	@Test
	public void windHandle() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("frame1");
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		
		driver.switchTo().parentFrame();
		String outerText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div")).getText();
		System.out.println(outerText);
		
		driver.switchTo().frame("frame2");
		text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		
	}
}
