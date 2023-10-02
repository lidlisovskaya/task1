package com.epam.autotasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class PasteBinPage extends BasePage {
    public static final String HOMEPAGE_URL = "https://pastebin.com/";
    @FindBy(name = ("PostForm[text]"))
    private WebElement pasteField;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationPushing;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationSelection;
    @FindBy(id = "postform-name")
    private WebElement pasteNameFieldPushing;
    @FindBy(xpath = ("//button[text() = 'Create New Paste']"))
    private WebElement newPasteButton;

    PasteBinPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public void writeTextInToNewPasteField(String textForNewPaste) {
        pasteField.sendKeys(textForNewPaste);
    }

    public void selectPasteExpiration() {
        pasteExpirationPushing.click();
        pasteExpirationSelection.click();
    }

    public void writeTextInToPasteNameField(String textForPasteName) {
        pasteNameFieldPushing.sendKeys(textForPasteName);
    }

    public void pressCreateNewPasteButton() {
        newPasteButton.click();
    }
}


