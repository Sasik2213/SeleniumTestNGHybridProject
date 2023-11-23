package org.test.testPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	public WebDriver driver;
	public WebDriverManager webDriverManager;

	@BeforeTest
	public void StartBrowser() {
		/* Setup Chrome Browser Driver */
		webDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qamoviesapp.ccbp.tech/");
	}

	@AfterTest
	public void closeBrowser() {
		/* Close the Browser */
		driver.quit();
	}


	/*
	 * Correct Login Credentials: Username: "rahul", Password: "rahul@2021" Test the
	 * login functionality with Valid Credentials, Close the browser window.
	 */
	@Test
	public void ValidCredentials() throws Exception {
		driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Trending Now']")).isDisplayed());
		
	}
}
