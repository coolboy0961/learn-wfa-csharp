package com.example.pageobject;

import org.openqa.selenium.WebElement;

import com.example.steps.ApplicationBootSteps;

import io.appium.java_client.windows.WindowsDriver;

public class MainForm {
    private WindowsDriver<WebElement> _driver;

    public MainForm() {
        _driver = ApplicationBootSteps.getDriver();
    }

    public void clickClickMeButton() {
        WebElement clickMeButton = _driver.findElementByName("Click me");
        clickMeButton.click();
    }

    public void clickCallApiButton() {
        WebElement callApiButton = _driver.findElementByName("Call Api");
        callApiButton.click();
    }
}
