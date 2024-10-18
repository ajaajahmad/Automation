package com.app.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class INF_9172 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://staging.goinfinito.com/auth/login");
    }

    @Test
    public void testRecordTables() throws InterruptedException {
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("ajaaj");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("User@123");
        driver.findElement(By.className("submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Reports')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//ul[@class='child-menu-wrapper']//span[@class='menu-heading' and text()='SMS']")).click();
        driver.findElement(By.xpath("//ul[contains(@class, 'child-menu-wrapper')]/li[contains(@class, 'menu-list-items')][descendant::span[text()='SMS']]//span[text()='Summary']")).click();
        Thread.sleep(5000);

        // Locate the view options
        String[] viewOptions = {"Date & Campaign", "Date", "Campaign"};
        for (String viewOption : viewOptions) {
            clickViewOption(viewOption);
            recordTableData(viewOption);
        }

        // Handle the "More" dropdown options
        WebElement moreOption = driver.findElement(By.id("more_con"));
        moreOption.click();
        Thread.sleep(5000);  // Wait for the dropdown to expand

        List<WebElement> moreViewOptions = driver.findElements(By.xpath("//div[@id='mis_sel']//div[@class='dropdown-content']//span"));
        for (WebElement moreViewOption : moreViewOptions) {
            String viewOptionName = moreViewOption.getText().replaceAll("[^a-zA-Z0-9]", "_");
            moreViewOption.click();
            Thread.sleep(5000);  // Wait for the table to load

            recordTableData(viewOptionName);

            // Click the "More" option again to reset the dropdown
            moreOption.click();
            Thread.sleep(5000);
        }
    }

    private void clickViewOption(String option) throws InterruptedException {
        WebElement viewOptionElement = driver.findElement(By.xpath("//li[contains(@class, 'ng-star-inserted')]/span[text()='" + option + "']"));
        viewOptionElement.click();
        Thread.sleep(5000);  // Wait for the table to load
    }

    private void recordTableData(String viewOptionName) {
        WebElement table = driver.findElement(By.className("data-table"));
        String htmlTable = extractHtmlTableWithStyles(table, viewOptionName);
        saveHtmlTableToFile(htmlTable, "20240604ms_summary_panel_" + viewOptionName + ".html");
    }

    private static String extractHtmlTableWithStyles(WebElement table, String viewOptionName) {
        StringBuilder htmlTable = new StringBuilder("<html><head><style>");
        htmlTable.append("table { border-collapse: collapse; width: 100%; }");
        htmlTable.append("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        htmlTable.append("th { background-color: #f2f2f2; }");
        htmlTable.append("</style></head><body>");
        htmlTable.append("<h2>").append(viewOptionName).append("</h2>");
        htmlTable.append("<table>");

        // Locate the table rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Extract column headers with CSS styles
        WebElement columnHeaderRow = rows.get(0);
        List<WebElement> headers = columnHeaderRow.findElements(By.tagName("th"));
        htmlTable.append("<tr>");
        for (WebElement header : headers) {
            htmlTable.append("<th>").append(header.getText()).append("</th>");
        }
        htmlTable.append("</tr>");

        // Extract column values with CSS styles
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            htmlTable.append("<tr>");
            for (WebElement cell : cells) {
                htmlTable.append("<td>").append(cell.getText()).append("</td>");
            }
            htmlTable.append("</tr>");
        }

        htmlTable.append("</table></body></html>");
        return htmlTable.toString();
    }

    private static void saveHtmlTableToFile(String htmlTable, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlTable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}