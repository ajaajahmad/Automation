package com.app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeSell {

	public static void main(String[] args) {
		// invoke browser
		// Chrome - ChromeDriver exten->Methods close get
		// Firefox - FirefoxDriver -> Methods close get
		// WebDriver close get
		// WebDriver Methods + Class Methods
		
		
		//System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Ajaaj.Ahmad\\Downloads\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ajaaj.Ahmad\\Downloads\\chromedriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Ajaaj.Ahmad\\Downloads\\chromedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://staging.goinfinito.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();		

	}

}
