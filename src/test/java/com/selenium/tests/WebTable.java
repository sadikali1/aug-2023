package com.selenium.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {

	@Test
	public void windHandle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div/div[4]"));
		System.out.println(elements.size());
		
		for(WebElement element: elements) {
			String email = element.getText();
			System.out.println(email);
		}
		
		
	}
	
}
