package com.epam.autotasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PasteBinPageTest {

    private WebDriver driver;
    protected PasteBinPage pasteBinPage;
    private static final String TEXT_FOR_NEW_PASTE = "Hello from WebDriver";
    private static final String TEXT_FOR_PASTE_NAME = "helloweb";


    @BeforeEach
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        pasteBinPage = new PasteBinPage(driver);
    }

    @Test
    public void createNewPaste() {
        pasteBinPage.openPage();
        pasteBinPage.writeTextInToNewPasteField(TEXT_FOR_NEW_PASTE);
        pasteBinPage.selectPasteExpiration();
        pasteBinPage.writeTextInToPasteNameField(TEXT_FOR_PASTE_NAME);
        pasteBinPage.pressCreateNewPasteButton();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

