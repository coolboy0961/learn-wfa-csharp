package com.example.steps;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.pageobject.MainForm;
import com.example.pageobject.MessageBoxForm;

import java.net.MalformedURLException;
import java.net.URL;

public class MainFormTestSteps {

    private static WindowsDriver<WebElement> driver;
    private MainForm mainForm;
    private MessageBoxForm messageBoxForm;

    @Given("アプリケーションが実行中である")
    public void the_application_is_running() throws MalformedURLException {
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("app", "C:\\Users\\Jiadong Chen\\source\\repos\\learn-wfa-csharp\\WinFormsApp1\\bin\\Debug\\net6.0-windows\\WinFormsApp1.exe");
        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), appCapabilities);
        mainForm = new MainForm(driver);
    }

    @When("ユーザーがClickMeボタンをクリックする")
    public void the_user_clicks_the_click_me_button() {
        messageBoxForm = mainForm.clickClickMeButton();
    }

    @Then("{string}のメッセージボックスが表示される")
    public void a_message_box_with_should_appear(String expectedMessage) {
        String actualMessage = messageBoxForm.getMessageBoxText();
        Assertions.assertEquals(expectedMessage, actualMessage);
        messageBoxForm.close();
        driver.quit();
    }
}


