package com.example;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.pageobject.MainForm;
import com.example.pageobject.MessageBoxForm;

import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainFormTest {
    private static final String WinAppDriverUrl = "http://127.0.0.1:4723";
    private static final String WindowsFormsAppPath = "C:\\Users\\Jiadong Chen\\source\\repos\\learn-wfa-csharp\\WinFormsApp1\\bin\\Debug\\net6.0-windows\\WinFormsApp1.exe";
    private static WindowsDriver<WebElement> _driver;
    private MainForm _mainForm;

    @BeforeEach
    public void Setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", WindowsFormsAppPath);
        _driver = new WindowsDriver<WebElement>(new URL(WinAppDriverUrl), capabilities);
        _mainForm = new MainForm(_driver);
    }

    @Test
    public void testClickMeButton() {
        String expectedMessage = "Hello World!";
        MessageBoxForm messageBoxForm = _mainForm.clickClickMeButton();
        String actualMessage = messageBoxForm.getMessageBoxText();
        messageBoxForm.close();
        assertEquals(expectedMessage, actualMessage);
    }

    @AfterEach
    public void TearDown() {
        _driver.quit();
    }
}
