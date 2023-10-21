package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;

public class ButtonExample {

	@Test
	public void testExample() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(element).build().perform();
		
		WebElement rightElement = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightElement).build().perform();
		
		WebElement elementClickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
		action.click(elementClickMe).build().perform();
		
		String text1 = driver.findElement(By.id("doubleClickMessage")).getText();
		String text2 = driver.findElement(By.id("rightClickMessage")).getText();
		String text3 = driver.findElement(By.id("dynamicClickMessage")).getText();
		Assert.assertEquals(text1, "You have done a double click");
		Assert.assertEquals(text2, "You have done a right click");
		Assert.assertEquals(text3, "You have done a dynamic click");
		
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
	}

}


// SeleniumManager -- 


// Actions -- 