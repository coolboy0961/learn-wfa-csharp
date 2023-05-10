using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Windows;
using System.IO;
using WinAppDriverTests;

namespace TestProject1.Tests
{
    public class MainFormTests
    {
        private const string WinAppDriverUrl = "http://127.0.0.1:4723";
        private const string WindowsFormsAppPath = @"C:\Users\Jiadong Chen\source\repos\learn-wfa-csharp\WinFormsApp1\bin\Debug\net6.0-windows\WinFormsApp1.exe";
        private static WindowsDriver<WindowsElement> _driver;
        private MainForm _mainForm;

        [SetUp]
        public void Setup()
        {
            var appiumOptions = new AppiumOptions();
            appiumOptions.AddAdditionalCapability("app", WindowsFormsAppPath);
            _driver = new WindowsDriver<WindowsElement>(new Uri(WinAppDriverUrl), appiumOptions);
            _mainForm = new MainForm(_driver);
        }

        [Test]
        public void ClickMeボタンをクリックしてメッセージボックスが出てokボタンでとじられること()
        {
            // Arrange
            var expectedMessage = "Hello World!";

            // Act
            var messageBoxForm = _mainForm.ClickHelloWorldButton();
            var actualMessage = messageBoxForm.MessageBoxText.Text;
            messageBoxForm.Close();

            // Assert
            Assert.That(actualMessage, Is.EqualTo(expectedMessage));
           
        }

        [TearDown]
        public void TearDown()
        {
            _driver?.Quit();
        }
    }
}
