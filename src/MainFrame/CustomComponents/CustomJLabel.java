package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;

import javax.swing.*;
import java.awt.*;

public class CustomJLabel extends JLabel
{
    public CustomJLabel()
    {
        super();
        this.setFont(Fonts.NORMAL_FONT);
        this.setForeground(Colors.SECONDARY_COLOR);
        this.setOpaque(false);
    }

    public CustomJLabel getClone()
    {
        CustomJLabel label = new CustomJLabel();

        label.setFont(this.getFont());
        label.setForeground(this.getForeground());

        return label;
    }
}
