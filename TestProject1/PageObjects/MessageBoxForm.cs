using OpenQA.Selenium.Appium.Windows;

namespace WinAppDriverTests
{
    public class MessageBoxForm
    {
        private readonly WindowsDriver<WindowsElement> _driver;

        public MessageBoxForm(WindowsDriver<WindowsElement> driver)
        {
            _driver = driver;
        }

        public WindowsElement MessageBox => _driver.FindElementByName("MessageBox");
        public WindowsElement MessageBoxText => (WindowsElement)MessageBox.FindElementByClassName("Static");
        public WindowsElement OkButton => (WindowsElement)MessageBox.FindElementByName("OK");

        public void Close()
        {
            OkButton.Click();
        }
    }
}
