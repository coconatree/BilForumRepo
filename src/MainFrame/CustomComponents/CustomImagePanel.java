package MainFrame.CustomComponents;

import AuthFrame.AuthFrameModel;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class CustomImagePanel extends JComponent
{
    private JLabel label;

    public CustomImagePanel(String txt, String urlR, Dimension size)
    {
        try
        {
            URL url = AuthFrameModel.class.getResource(urlR);

            System.out.println(url.toString());

            BufferedImage imgBuffer = ImageIO.read(url);

            Image img = imgBuffer.getScaledInstance(size.width, size.height, Image. SCALE_SMOOTH);

            this.label =  new JLabel(new ImageIcon(img));
        }
        catch (IOException e)
        {
            this.label = new JLabel(txt);
            e.printStackTrace();
        }

        MigLayout layout = new MigLayout("","[grow]", "[grow]");
        this.setLayout(layout);
        this.add(this.label, "grow");
    }

}
