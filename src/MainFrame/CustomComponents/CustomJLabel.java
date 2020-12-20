package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;

import javax.swing.*;

public class CustomJLabel extends JLabel
{
    public CustomJLabel()
    {
        super();
        this.setFont(Fonts.NORMAL_FONT);
        this.setForeground(Colors.SECONDARY_COLOR);
    }
}
