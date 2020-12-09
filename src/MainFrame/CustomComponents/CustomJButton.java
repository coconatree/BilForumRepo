package MainFrame.CustomComponents;

import Static.Colors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomJButton extends JButton
{
    public CustomJButton()
    {
        super();

        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        this.setBackground(Colors.BUTTON_COLOR);
        this.setForeground(Color.white);

        this.setUI(new BasicButtonUI());

    }
}
