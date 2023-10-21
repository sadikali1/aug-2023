package com.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

	static WebDriver driver;
	
	@Before
	public void testSetup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		System.out.println("Before Scenario");
	}
	
	
	@After
	public void tearDown() {
		System.out.println("After Scenario");
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStepMethod() {
		System.out.println("Before Setup");
	}
	
	
	@AfterStep
	public void afterStepText() {
		System.out.println("After Setup");
	}
}
