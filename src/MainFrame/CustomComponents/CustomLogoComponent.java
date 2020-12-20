package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;

import javax.swing.*;
import java.awt.*;

public class CustomLogoComponent extends JComponent
{
    private String text;
    private JLabel logoLabel;

    public CustomLogoComponent(String text)
    {
        super();
        this.text = text;
        logoLabel = new CustomJLabel();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Colors.SECONDARY_COLOR);
        g.setFont(Fonts.TITLE_FONT);

        g.drawString(this.text, 100, 100);
    }
}
