package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTabOrWin {

	@Test
	public void windHandle() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://facebook.com");
		
	}
}
