package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomJTextField extends JTextField
{
    private Shape shape;

    public CustomJTextField(int size)
    {
        super(size);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        this.setFont(Fonts.NORMAL_FONT);
        this.setBackground(Colors.MAIN_BACKGROUND_COLOR);
    }
}