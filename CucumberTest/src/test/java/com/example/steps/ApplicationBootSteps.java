package com.example.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class ApplicationBootSteps {
    private static WindowsDriver<WebElement> driver;
    private WireMockServer wireMockServer;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("app", "C:\\Users\\Jiadong Chen\\source\\repos\\learn-wfa-csharp\\WinFormsApp1\\bin\\Debug\\net6.0-windows\\WinFormsApp1.exe");
        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), appCapabilities);

        wireMockServer = new WireMockServer(3000); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        WireMock.configureFor("localhost", 3000);
    }

    @After
    public void tearDown() {
        driver.quit();
        wireMockServer.stop();
    }

    public static WindowsDriver<WebElement> getDriver() {
        return driver;
    }
}
