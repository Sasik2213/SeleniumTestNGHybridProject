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

public class Login {

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

	/* Test the Login Page UI */

	@Test
	public void LoginUI() throws Exception {

		/* Test whether the Website logo image is displayed */
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='login website logo']")).isDisplayed());
		/* Test whether the Heading text is "Login" */
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Login']")).isDisplayed());
		/* Test whether the Username label text is "USERNAME" */
		Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='USERNAME']")).getText()
				.equalsIgnoreCase("USERNAME"));
		/* Test whether the Password label text is "PASSWORD" */
		Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='PASSWORD']")).getText()
				.equalsIgnoreCase("PASSWORD"));
		/* Test the "Login" button */
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	/* Test the Login Page Functionalities */
	@Test
	public void LoginPageFunctionalites() throws Exception {
		/* Test the login functionality with empty input fields */
		/*
		 * Test the login functionality with empty USERNAME, Test the login
		 * functionality with an empty PASSWORD,
		 */
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		/*
		 * Test the login functionality with Invalid Credentials (correct username and
		 * wrong password),
		 */
		driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("rahul");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Assert.assertTrue(driver.findElement(By.xpath("(//p[@class='error-message'])[1]")).isDisplayed());
	}
	

}
