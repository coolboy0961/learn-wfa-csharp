using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Windows;
using System.IO;

namespace WinAppDriverTests
{
    public class Tests
    {
        private const string WinAppDriverUrl = "http://127.0.0.1:4723";
        private const string WindowsFormsAppPath = @"C:\Users\Jiadong Chen\source\repos\WinFormsApp1\bin\Debug\net6.0-windows\WinFormsApp1.exe";
        private static WindowsDriver<WindowsElement> _driver;

        [SetUp]
        public void Setup()
        {
            // Console.WriteLine("");
            // WinAppDriverセッションの設定
            var appiumOptions = new AppiumOptions();
            appiumOptions.AddAdditionalCapability("app", WindowsFormsAppPath);
            _driver = new WindowsDriver<WindowsElement>(new Uri(WinAppDriverUrl), appiumOptions);
        }

        [Test]
        public void Test1()
        {
            // ボタンを探す
            var helloWorldButton = _driver.FindElementByName("Click me");

            // ボタンをクリックする
            helloWorldButton.Click();

            // MessageBoxが表示されていることを確認する
            // System.Threading.Thread.Sleep(2000); // 2秒待機
            var messageBox = _driver.FindElementByName("MessageBox");
            Assert.That(messageBox, Is.Not.Null);

            // MessageBoxのテキストを確認する
            var messageBoxText = messageBox.FindElementByClassName("Static");
            Assert.That(messageBoxText.Text, Is.EqualTo("Hello World!"));

            // OKボタンを探してクリックする
            var okButton = messageBox.FindElementByName("OK");
            okButton.Click();
        }

        [TearDown]
        public void TearDown()
        {
            _driver?.Quit();
        }
    }
}
