package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.github.tomakehurst.wiremock.client.WireMock;

import com.example.pageobject.MainForm;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class DisplayApiCalledResultMessageBoxSteps {
    private MainForm mainForm;

    public DisplayApiCalledResultMessageBoxSteps() {
        this.mainForm = new MainForm();
    }

    @Given("APIのモックがセットされている")
    public void the_api_mock_is_set() {
        WireMock.stubFor(get(urlEqualTo("/api/v1/users?id=1"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\"message\": \"API Called SuccessFully!\"}")));
    }

    @When("ユーザーがCallApiボタンをクリックする")
    public void the_user_clicks_the_call_api_button() {
        mainForm.clickCallApiButton();
    }
}


