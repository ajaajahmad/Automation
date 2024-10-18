package com.app.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class smsSummaryPanel {

    private static final String URL = "https://staging.goinfinito.com/auth/login";
    private static final String USERNAME = "ajaaj";
    private static final String PASSWORD = "User@123";

    private static final String[] VIEW_OPTIONS = {"Date & Campaign", "Date", "Campaign"};
    private static final String[][] EXPECTED_COLUMNS = {
        {"Date", "Campaign Name", "Executed By", "Executed On", "Total", "Type", "Sent", "Delivered", "Failed", "Status Awaited", "NDNC", "Total Link Clicks", "Unique Link Clicks", "Rejected", "Currency Used"},
        {"Date", "Campaigns", "Total", "Type", "Sent", "Delivered", "Failed", "Status Awaited", "NDNC", "Total Link Clicks", "Unique Link Clicks", "Rejected", "Currency Used"},
        {"Campaign Name", "Executed By", "Executed On", "Campaigns", "Total", "Type", "Sent", "Delivered", "Failed", "Status Awaited", "NDNC", "Total Link Clicks", "Unique Link Clicks", "Rejected", "Currency Used"}
    };

    private static List<TestResult> testResults = new ArrayList<>();

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            setup(driver);
            login(driver, USERNAME, PASSWORD);
            navigateToSmsSummary(driver);
            verifyViewOptions(driver);
        } finally {
            driver.quit();
            generateHtmlReport("test_results2.html");
        }
    }

    private static void setup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    private static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
        waitFor(5000);
        driver.findElement(By.className("submit")).click();
    }

    private static void navigateToSmsSummary(WebDriver driver) {
        waitFor(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Reports')]")).click();
        waitFor(5000);
        driver.findElement(By.xpath("//ul[@class='child-menu-wrapper']//span[@class='menu-heading' and text()='SMS']")).click();
        waitFor(5000);
        driver.findElement(By.xpath(
                "//ul[contains(@class, 'child-menu-wrapper')]/li[contains(@class, 'menu-list-items')][descendant::span[text()='SMS']]//span[text()='Summary']"))
                .click();
    }

    private static void verifyViewOptions(WebDriver driver) {
        for (int i = 0; i < VIEW_OPTIONS.length; i++) {
            String viewOption = VIEW_OPTIONS[i];
            String[] expected = EXPECTED_COLUMNS[i];

            retryClickViewOption(driver, viewOption, 3);

            waitFor(5000); // Wait for 5 seconds to ensure the table is fully loaded

            List<String> actual = getTableColumns(driver);

            compareColumns(i + 1, viewOption, expected, actual);
        }
    }

    private static void retryClickViewOption(WebDriver driver, String option, int retries) {
        for (int attempt = 1; attempt <= retries; attempt++) {
            try {
                WebElement viewOptionElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'ng-star-inserted')]/span[text()='" + option + "']")));
                viewOptionElement.click();

                // Wait for the table to load by waiting for a generic table header element
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='data-table']/thead/tr/th")));
                break; // If click and wait are successful, break out of the loop
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                if (attempt == retries) {
                    throw e; // If it's the last attempt, throw the exception
                }
                System.out.println("Retrying due to stale element reference: attempt " + attempt);
                waitFor(5000);
            }
        }
    }

    private static List<String> getTableColumns(WebDriver driver) {
        WebElement tableHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='data-table']/thead")));
        List<WebElement> columnElements = tableHeader.findElements(By.tagName("th"));
        List<String> columnNames = new ArrayList<>();
        for (WebElement columnElement : columnElements) {
            columnNames.add(columnElement.getText().trim());
        }
        System.out.println("Retrieved columns: " + columnNames);
        return columnNames;
    }

    private static void compareColumns(int testId, String viewOption, String[] expected, List<String> actual) {
        boolean columnsMatch = Arrays.equals(actual.toArray(), expected);
        String status = columnsMatch ? "Pass" : "Fail";
        String comments = columnsMatch ? "" : "Mismatch in columns";

        if (!columnsMatch) {
            comments += "\nExpected: " + Arrays.toString(expected);
            comments += "\nActual: " + actual;
        }

        testResults.add(new TestResult(testId, viewOption, Arrays.toString(expected), actual.toString(), status, comments));

        System.out.println("Columns for view option '" + viewOption + "' " + (columnsMatch ? "match" : "do not match") + " the expected values.");
    }

    private static void generateHtmlReport(String filePath) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html><head><style>");
        htmlContent.append("table { border-collapse: collapse; width: 100%; }");
        htmlContent.append("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        htmlContent.append("th { background-color: #f2f2f2; }");
        htmlContent.append("</style></head><body>");
        htmlContent.append("<h2>Test Results</h2>");
        htmlContent.append("<table>");
        htmlContent.append("<tr>");
        htmlContent.append("<th>TestId</th>");
        htmlContent.append("<th>Test Scenarios</th>");
        htmlContent.append("<th>Expected Results</th>");
        htmlContent.append("<th>Actual Results</th>");
        htmlContent.append("<th>Test Status</th>");
        htmlContent.append("<th>Comments</th>");
        htmlContent.append("</tr>");

        for (TestResult result : testResults) {
            htmlContent.append("<tr>");
            htmlContent.append("<td>").append(result.getTestId()).append("</td>");
            htmlContent.append("<td>").append(result.getTestScenario()).append("</td>");
            htmlContent.append("<td>").append(result.getExpectedResult()).append("</td>");
            htmlContent.append("<td>").append(result.getActualResult()).append("</td>");
            htmlContent.append("<td>").append(result.getTestStatus()).append("</td>");
            htmlContent.append("<td>").append(result.getComments()).append("</td>");
            htmlContent.append("</tr>");
        }

        htmlContent.append("</table></body></html>");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class TestResult {
        private final int testId;
        private final String testScenario;
        private final String expectedResult;
        private final String actualResult;
        private final String testStatus;
        private final String comments;

        public TestResult(int testId, String testScenario, String expectedResult, String actualResult, String testStatus, String comments) {
            this.testId = testId;
            this.testScenario = testScenario;
            this.expectedResult = expectedResult;
            this.actualResult = actualResult;
            this.testStatus = testStatus;
            this.comments = comments;
        }

        public int getTestId() {
            return testId;
        }

        public String getTestScenario() {
            return testScenario;
        }

        public String getExpectedResult() {
            return expectedResult;
        }

        public String getActualResult() {
            return actualResult;
        }

        public String getTestStatus() {
            return testStatus;
        }

        public String getComments() {
            return comments;
        }
    }
}