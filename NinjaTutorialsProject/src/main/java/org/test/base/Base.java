package org.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fis;
	public static File fs;
	public Base(WebDriver driver,Properties properties) {
		this.driver=driver;
		this.properties=properties;
		
	}
	/*
	 * public static void main(String[] args) { properties = new Properties(); fs =
	 * new File(System.getProperty("user.dir")+
	 * "\\src\\main\\java\\org\\config\\prop\\config.properties"); try { fis = new
	 * FileInputStream(fs); properties.load(fis); } catch (Throwable e) { // TODO:
	 * handle exception e.printStackTrace(); }
	 * System.out.println(properties.getProperty("browser"));
	 * System.out.println(properties.getProperty("url"));
	 * 
	 * }
	 */
	
	public static WebDriver setBrowserImplemented(String browser,WebDriver driver) {
		properties = new Properties();
		fs = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\config\\prop\\config.properties");
		try {
			fis = new FileInputStream(fs);
			properties.load(fis);	
		}
		catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (browser.equalsIgnoreCase(properties.getProperty("browser"))) {
			
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase(properties.getProperty("browser"))) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		driver.get(properties.getProperty("url"));
		return driver;
		
	}
}
