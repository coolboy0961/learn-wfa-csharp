namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.helloWorldButton.Click += new System.EventHandler(this.HelloWorldButton_Click);
        }

        // �{�^���̃N���b�N�C�x���g�n���h��
        private void HelloWorldButton_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Hello World!", "MessageBox");
        }
    }
}