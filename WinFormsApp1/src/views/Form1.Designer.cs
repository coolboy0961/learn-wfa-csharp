namespace WinFormsApp1
{
    partial class Form1
    {
        private Button helloWorldButton;

        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Text = "Form1";

            // ボタンの作成と設定
            this.helloWorldButton = new System.Windows.Forms.Button();
            this.helloWorldButton.Location = new System.Drawing.Point(350, 200);
            this.helloWorldButton.Size = new System.Drawing.Size(100, 50);
            this.helloWorldButton.Text = "Click me";

            // ボタンをフォームに追加
            this.Controls.Add(this.helloWorldButton);
        }

        #endregion
    }
}