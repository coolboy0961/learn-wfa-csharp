package com.example.pageobject;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class MainForm {
    private WindowsDriver<WebElement> _driver;

    public MainForm(WindowsDriver<WebElement> driver) {
        _driver = driver;
    }

    public MessageBoxForm clickClickMeButton() {
        WebElement helloWorldButton = _driver.findElementByName("Click me");
        helloWorldButton.click();
        return new MessageBoxForm(_driver);
    }
}
