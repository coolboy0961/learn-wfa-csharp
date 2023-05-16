package com.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class MessageBoxForm {
    private WindowsDriver<WebElement> _driver;

    public MessageBoxForm(WindowsDriver<WebElement> driver) {
        _driver = driver;
    }

    public String getMessageBoxText() {
        WebElement messageBox = _driver.findElementByName("MessageBox");
        WebElement messageText = messageBox.findElement(By.className("Static"));
        return messageText.getText();
    }

    public void close() {
        WebElement okButton = _driver.findElementByName("OK");
        okButton.click();
    }
}
