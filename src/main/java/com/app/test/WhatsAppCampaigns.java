package com.app.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WhatsAppCampaigns {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
		driver.get("https://staging.goinfinito.com/auth/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("virk_vf2");
		driver.findElement(By.id("mat-input-1")).sendKeys("Sms-3246");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Blog']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Blog']")).getText());
		driver.findElement(By.xpath("//span[text()='WhatsApp']")).click();
		driver.findElement(By.xpath("//div[@id='collapseBasic2']//span[@class='menu-heading'][normalize-space()='Campaigns']")).click();		
		driver.findElement(By.xpath("//span[normalize-space()='Create Campaign']")).click();
		driver.findElement(By.xpath("//body/app-root/div[@class='custom-sidebar big-sidebar']/app-home-layout[@class='ng-star-inserted']/div[@class='d-flex wrapper home-wrapper']/div[@class='page-content-wrapper full-page-content-wrapper']/app-create-campaign[@class='ng-star-inserted']/div[@class='internal create-campaign-wrapper custom-campaign-wrapper component-wrapper container-fluid']/app-set-parameters[@class='ng-star-inserted']/form[@class='ng-untouched ng-pristine ng-invalid']/div[@class='set-parameters steps-frame mb-3']/div[@class='row']/div[2]/app-custom-select-with-create[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Auto SMS']")).click();
		driver.findElement(By.xpath("//app-custom-select-with-create[@class='wa-business-number']//span[@class='placeholder-color form-control align-items-center justify-content-between d-flex']")).click();
		driver.findElement(By.xpath("//span[@class='ng-star-inserted'][normalize-space()='+91-8448098743']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Import Contacts']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Lists')]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search List'])[1]")).sendKeys("WhatsApp QA");
		driver.findElement(By.xpath("(//button[normalize-space()='Go'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='btn process-file btn-design']")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//button[@class='btn btn-design']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='mat-radio-inner-circle'])[6]")).click();
		driver.findElement(By.xpath("//button[@class='btn import-btn btn-design mr-3 custom-multiple-buttons-spacing']")).click();
		driver.findElement(By.xpath("(//span[@class='ellipsis-text custom-placement-ltr'][normalize-space()='Select'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='ng-star-inserted'][normalize-space()='English (US)']")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-design btn-send mr-3 rtl-margin-placement'])[1]")).click();
		driver.findElement(By.xpath("(//span[normalize-space()='Send Now'])[1]")).click();
		//driver.findElement(By.xpath("//textarea[@placeholder='Enter mobile numbers separated by comma(,).']")).sendKeys("8572995255");
		//driver.findElement(By.xpath("//button[@class='btn btn-design rtl-margin-placement']")).click();

	}

}
