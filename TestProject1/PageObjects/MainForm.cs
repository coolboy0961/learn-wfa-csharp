using OpenQA.Selenium.Appium.Windows;

namespace WinAppDriverTests
{
    public class MainForm
    {
        private readonly WindowsDriver<WindowsElement> _driver;

        public MainForm(WindowsDriver<WindowsElement> driver)
        {
            _driver = driver;
        }

        public WindowsElement HelloWorldButton => _driver.FindElementByName("Click me");

        public MessageBoxForm ClickHelloWorldButton()
        {
            HelloWorldButton.Click();
            return new MessageBoxForm(_driver);
        }
    }
}
