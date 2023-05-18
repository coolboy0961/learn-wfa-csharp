package com.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.steps.ApplicationBootSteps;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageBoxForm {
    private WindowsDriver<WebElement> _driver;

    public MessageBoxForm() {
        _driver = ApplicationBootSteps.getDriver();
    }

    public String getMessageBoxText() {
        By messageboxSelector = By.name("MessageBox");
        WebDriverWait wait = new WebDriverWait(_driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageboxSelector));
        WebElement messageBox = _driver.findElement(messageboxSelector);
        WebElement messageText = messageBox.findElement(By.className("Static"));
        return messageText.getText();
    }

    public void close() {
        WebElement okButton = _driver.findElementByName("OK");
        okButton.click();
    }
}
