package com.epam.autotasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PastebinPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://pastebin.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebElement newPaste = waitForElementLocatedBy(driver,By.name("PostForm[text]"));
        newPaste.sendKeys("Hello from Web Driver");
        WebElement elem = waitForElementLocatedBy(driver,By.id("select2-postform-expiration-container"));
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(elem)).isDisplayed();
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elem)).isDisplayed();
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elem)).click();
        WebElement pasteExpiration = waitForElementLocatedBy(driver,By.xpath("//span[@class= 'select2-results']/ul/li[3]"));
        pasteExpiration.click();
        WebElement pasteName = waitForElementLocatedBy(driver,By.id("postform-name"));
        pasteName.sendKeys("helloweb");
        driver.findElement(By.xpath("//button[text() = 'Create New Paste']")).click();
        driver.quit();

    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
