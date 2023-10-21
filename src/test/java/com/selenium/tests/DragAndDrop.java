package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public void testDragAndDrop() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}
	
	@Test
	public void testDragAndDropByPosition() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/dragabble");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(By.id("dragBox"));

		action.dragAndDropBy(sourceElement, 100, 100).build().perform();
		
	}
}
