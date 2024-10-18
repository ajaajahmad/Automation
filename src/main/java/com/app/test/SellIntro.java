package com.app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SellIntro {

    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "C:\\CodeBase\\Automation\\chromedriver\\chromedriver.exe");
    	//System.setProperty("webdriver.gecko.driver", "C:\\CodeBase\\Automation\\geckodriver\\geckodriver.exe");
        //System.setProperty("webdriver.edge.driver", "C:\\CodeBase\\Automation\\edgedriver\\msedgedriver.exe");

        // Create a new ChromeDriver instance
        //WebDriver driver = new ChromeDriver();
    	
    	//Create a new FireFoxDriver instance
    	WebDriver driver = new FirefoxDriver();
        
        //Create a new EdgeDriver instance
        //WebDriver driver = new EdgeDriver();

        // Maximize the browser window (optional)
        //driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://staging.goinfinito.com");

        // Application logic here (e.g., interact with elements on the page)
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Close the browser (optional)
        driver.close();
    }
}