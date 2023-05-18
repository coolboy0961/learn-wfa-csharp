package com.example.steps;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.pageobject.MainForm;
import com.example.pageobject.MessageBoxForm;

public class DisplayApiCalledResultMessageBoxSteps {
    private MainForm mainForm;
    private MessageBoxForm messageBoxForm;

    public DisplayApiCalledResultMessageBoxSteps() {
        this.mainForm = new MainForm();
    }

    @Given("APIのモックがセットされている")
    public void the_api_mock_is_set() {
        System.out.println("blank");
    }

    @When("ユーザーがCallApiボタンをクリックする")
    public void the_user_clicks_the_call_api_button() {
        mainForm.clickCallApiButton();
    }
}


