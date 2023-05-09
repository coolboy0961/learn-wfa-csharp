using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Windows;
using System.IO;

namespace WinAppDriverTests
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
        public void ClickMe�{�^�����N���b�N���ă��b�Z�[�W�{�b�N�X���o��ok�{�^���łƂ����邱��()
        {
            var messageBoxForm = _mainForm.ClickHelloWorldButton();
            Assert.Multiple(() =>
            {
                Assert.That(messageBoxForm.MessageBox, Is.Not.Null);
                Assert.That(messageBoxForm.MessageBoxText.Text, Is.EqualTo("Hello World!"));
            });
            messageBoxForm.Close();
        }

        [TearDown]
        public void TearDown()
        {
            _driver?.Quit();
        }
    }
}
