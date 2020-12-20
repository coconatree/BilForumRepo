package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomJButton extends JButton
{
    public CustomJButton()
    {
        super();

        this.setFont(Fonts.BUTTON_FONT);
        this.setBackground(Colors.BUTTON_COLOR);
        this.setForeground(Colors.MAIN_COLOR);
        this.setFont(Fonts.BUTTON_FONT);

        this.setUI(new BasicButtonUI());

    }
}
