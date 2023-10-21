package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestedIFrame {

	@Test
	public void windHandle() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("frame1");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));

		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		String outerText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div")).getText();
		System.out.println(outerText);
		
	}
}
