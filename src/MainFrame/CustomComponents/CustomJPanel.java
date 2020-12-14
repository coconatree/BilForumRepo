package MainFrame.CustomComponents;

import Static.Colors;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel
{
    public CustomJPanel()
    {
        super();
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(Colors.MAIN_BACKGROUND_COLOR);
    }
}
