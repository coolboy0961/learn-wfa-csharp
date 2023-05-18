package com.example.steps;

import io.cucumber.java.en.When;

import com.example.pageobject.MainForm;

public class DisplayHelloWorldMessageBoxSteps {

    private MainForm mainForm;

    public DisplayHelloWorldMessageBoxSteps() {
        this.mainForm = new MainForm();
    }

    @When("ユーザーがClickMeボタンをクリックする")
    public void the_user_clicks_the_click_me_button() {
        mainForm.clickClickMeButton();
    }
}


