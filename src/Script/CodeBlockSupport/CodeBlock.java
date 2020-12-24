package Script.CodeBlockSupport;

import MainFrame.CustomComponents.CustomJTextPane;

import javax.swing.*;

public class CodeBlock extends JComponent
{
    private JTextPane textPane;

    private String data;

    public CodeBlock(String data)
    {
        this.data = data;

        this.init();
    }

    private void init()
    {
        this.textPane = new CustomJTextPane();

        this.textPane.setEnabled(false);
        this.textPane.setText(this.data);
    }

}
