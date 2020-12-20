package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;

import javax.swing.*;
import java.awt.*;

public class CustomJTextField extends JTextField
{
    public CustomJTextField(int size)
    {
        super(size);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(3, 10, 3, 10)));

        this.setOpaque(false);

        this.setFont(Fonts.NORMAL_FONT);
        this.setBackground(Colors.MAIN_COLOR);
    }
}