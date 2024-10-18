package com.app.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class INF7230 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
		driver.get("https://staging.goinfinito.com/auth/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("virk_vf2");
		driver.findElement(By.id("mat-input-1")).sendKeys("Sms-3246");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Blog']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Blog']")).getText());
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Reports']")).click();
		driver.findElement(By.xpath("//div[@class='d-flex child-menu-event']//span[@class='menu-heading'][normalize-space()='SMS']")).click();		
		driver.findElement(By.xpath("(//div[@class='label-with-wrrow-wrapper'])[38]")).click();
		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='Credit Used']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='Credit Used']")).getText());
		driver.findElement(By.xpath("//span[normalize-space()='Date & Campaign']")).click();
		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='Credit Used']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='Credit Used']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Date']")).click();
		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='Credit Used']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='Credit Used']")).getText());
		driver.close();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Auto SMS']")).click();
		driver.findElement(By.xpath("//input[@value='Personalised']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Import Contacts']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Lists')]")).click();
		driver.findElement(By.xpath("//label[@for='mat-checkbox-5-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
		driver.findElement(By.xpath("//button[@class='btn process-file btn-design']")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//button[@class='btn btn-design']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='mat-radio-inner-circle'])[7]")).click();
		driver.findElement(By.xpath("//button[@class='btn import-btn btn-design mr-3 custom-multiple-buttons-spacing']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter mobile numbers separated by comma(,).']")).sendKeys("9090909090");
		//driver.findElement(By.xpath("//button[@class='btn btn-design rtl-margin-placement']")).click();
		driver.findElement(By.xpath("(//span[normalize-space()='Send'])[1]")).click();
		driver.findElement(By.xpath("(//span[normalize-space()='Send Now'])[1]")).click();	}

}
