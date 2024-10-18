package com.app.test.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the website
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            
            // Select the first checkbox
            By firstCheckbox = By.xpath("(//input[@type='checkbox'])[1]");
            driver.findElement(firstCheckbox).click();
            
            // Verify that the checkbox is selected
            Assert.assertTrue(driver.findElement(firstCheckbox).isSelected(), "Checkbox should be selected");
            
            // Pause for visual clarity (avoid using Thread.sleep in tests; consider WebDriverWait)
            Thread.sleep(2000);
            
            // Deselect the checkbox
            driver.findElement(firstCheckbox).click();
            
            // Verify that the checkbox is no longer selected
            Assert.assertFalse(driver.findElement(firstCheckbox).isSelected(), "Checkbox should be deselected");
            
            // Count and print the total number of checkboxes
            int checkboxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
            System.out.println("Total number of checkboxes: " + checkboxCount);
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
