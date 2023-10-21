package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FBExample {

	WebDriver driver;

	@BeforeClass
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browserType) {
		System.out.println(browserType);
		if(browserType.equals("chrome"))
			driver = new ChromeDriver();
		else if(browserType.equals("firefox"))
			driver = new FirefoxDriver();
		else if(browserType.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Please pass valid browser type value");
		}
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testExample() {
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		WebElement userNameInput = driver.findElement(By.name("firstname"));
		userNameInput.clear();
		userNameInput.sendKeys("Test1");

		driver.findElement(By.name("lastname")).sendKeys("Ali");
		driver.findElement(By.name("reg_email__")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Password");

		WebElement elementday = driver.findElement(By.xpath("//select[@aria-label='Day']"));
		Select selectDay = new Select(elementday);
		selectDay.selectByIndex(10);

		WebElement elementMonth = driver.findElement(By.xpath("//select[@name=\"birthday_month\"]"));
		Select selectMonth = new Select(elementMonth);
		// selectMonth.selectByValue("5");
		selectMonth.selectByVisibleText("Nov");

		WebElement element = driver.findElement(By.xpath("//input[@value='2']"));
		System.out.println(element.isSelected());
		element.click();
		System.out.println(element.isSelected());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

// Selenium Wait functions

// Implicit wait
// explicit wait