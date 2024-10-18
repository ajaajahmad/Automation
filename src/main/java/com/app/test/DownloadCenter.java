package com.app.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DownloadCenter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
		driver.get("https://staging.goinfinito.com/auth/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("ajaaj");
		driver.findElement(By.id("mat-input-1")).sendKeys("User@1111");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Blog']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Blog']")).getText());
		driver.findElement(By.xpath("//span[text()='Download']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Manual']")).click();
		driver.findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='placeholder-color form-control align-items-center justify-content-between d-flex'])[3]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ng-star-inserted'][normalize-space()='AutoSMS'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Save']")).click();
		driver.findElement(By.xpath("//span[@class='ng-star-inserted'][normalize-space()='+91-8448098743']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Import Contacts']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Lists')]")).click();
		driver.findElement(By.xpath("//label[@for='mat-checkbox-5-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
		driver.findElement(By.xpath("//button[@class='btn process-file btn-design']")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//button[@class='btn btn-design']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='mat-radio-inner-circle'])[4]")).click();
		driver.findElement(By.xpath("//button[@class='btn import-btn btn-design mr-3 custom-multiple-buttons-spacing']")).click();
		driver.findElement(By.xpath("(//span[@class='ellipsis-text custom-placement-ltr'][normalize-space()='Select'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='ng-star-inserted'][normalize-space()='Marathi']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter mobile numbers separated by comma(,).']")).sendKeys("8572995255");
		driver.findElement(By.xpath("//button[@class='btn btn-design rtl-margin-placement']")).click();

	}

}
