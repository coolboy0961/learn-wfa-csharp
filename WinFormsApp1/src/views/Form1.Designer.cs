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
            helloWorldButton = new Button();
            callApibutton = new Button();
            SuspendLayout();
            // 
            // helloWorldButton
            // 
            helloWorldButton.Location = new Point(216, 200);
            helloWorldButton.Name = "helloWorldButton";
            helloWorldButton.Size = new Size(100, 50);
            helloWorldButton.TabIndex = 0;
            helloWorldButton.Text = "Click me";
            // 
            // button1
            // 
            callApibutton.Location = new Point(447, 200);
            callApibutton.Name = "CallApi";
            callApibutton.Size = new Size(100, 50);
            callApibutton.TabIndex = 1;
            callApibutton.Text = "Call Api";
            callApibutton.Click += CallApibutton_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(callApibutton);
            Controls.Add(helloWorldButton);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
        }

        #endregion

        private Button callApibutton;
    }
}