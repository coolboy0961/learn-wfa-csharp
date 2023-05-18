package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import com.example.pageobject.MainForm;
import com.example.pageobject.MessageBoxForm;

public class DisplayHelloWorldMessageBoxSteps {

    private MainForm mainForm;
    private MessageBoxForm messageBoxForm;

    public DisplayHelloWorldMessageBoxSteps() {
        this.mainForm = new MainForm();
    }

    @When("ユーザーがClickMeボタンをクリックする")
    public void the_user_clicks_the_click_me_button() {
        mainForm.clickClickMeButton();
    }
}


