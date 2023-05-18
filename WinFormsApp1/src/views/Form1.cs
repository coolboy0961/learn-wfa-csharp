using System.Net.Http;
using Newtonsoft.Json;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.helloWorldButton.Click += new System.EventHandler(this.HelloWorldButton_Click);
        }

        // ボタンのクリックイベントハンドラ
        private void HelloWorldButton_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Hello World!", "MessageBox");
        }

        private async void CallApibutton_Click(object sender, EventArgs e)
        {
            string url = "http://localhost:3000/api/v1/users?id=1";
            string resultMessage = "";

            try
            {
                using (HttpClient client = new HttpClient())
                {
                    HttpResponseMessage response = await client.GetAsync(url);
                    if (response.IsSuccessStatusCode)
                    {
                        string content = await response.Content.ReadAsStringAsync();
                        dynamic item = JsonConvert.DeserializeObject(content);
                        resultMessage = item.message;
                    }
                    else
                    {
                        resultMessage = "API Called Successfully!";
                    }
                }
            }
            catch
            {
                resultMessage = "エラーが発生しました。";
            }

            MessageBox.Show(resultMessage, "MessageBox");
            //MessageBox.Show("API Called Successfully!", "MessageBox");
        }
    }
}