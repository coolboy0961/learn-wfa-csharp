package com.example.steps;

import com.example.pageobject.MainForm;
import com.example.pageobject.MessageBoxForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class MainFormCommonSteps {
    private MainForm mainForm;
    private MessageBoxForm messageBoxForm;

    public MainFormCommonSteps() {
        this.mainForm = new MainForm();
        this.messageBoxForm = new MessageBoxForm();
    }
    
    @Then("{string}のメッセージボックスが表示される")
    public void a_message_box_with_should_appear(String expectedMessage) {
        String actualMessage = messageBoxForm.getMessageBoxText();
        Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
        messageBoxForm.close();
    }
    
}
