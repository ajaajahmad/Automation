package com.app.test.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        try {
            // Set timeouts and maximize the window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            
            // Navigate to the website
            driver.get("https://rahulshettyacademy.com/angularpractice");

            // Fill in the form fields
            driver.findElement(By.name("name")).sendKeys("Patil");
            driver.findElement(By.name("email")).sendKeys("patil@cc.com");
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("Asdf@123");
            driver.findElement(By.id("exampleCheck1")).click();

            // Select Gender
            driver.findElement(By.id("exampleFormControlSelect1")).click();
            driver.findElement(By.xpath("//option[contains(text(),'Male')]")).click();

            // Select Employment Status
            driver.findElement(By.id("inlineRadio1")).click();

            // Set Date of Birth
            WebElement dateOfBirthField = driver.findElement(By.name("bday"));
            String dob = "10-03-2009";
            dateOfBirthField.sendKeys(dob);

            // Pause for visual confirmation
            Thread.sleep(2000);

            // Submit the form
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            
            // Pause for result visibility
            Thread.sleep(2000);

            // Retrieve and print the success message
            String successMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
            System.out.println("Form submission message: " + successMessage);

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}