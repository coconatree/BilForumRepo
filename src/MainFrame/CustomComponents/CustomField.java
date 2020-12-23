package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class CustomField extends JComponent
{
    private JPanel panelL;
    private JPanel panelR;

    private JLabel nameLabel;

    private JTextField tf;

    private String name;
    private String data;

    public CustomField(String name, String data)
    {
        this.name = name;
        this.data = data;

        this.nameLabel = new CustomJLabel();
        this.nameLabel.setText(this.name);


        this.tf = new CustomJTextField(5);
        this.tf.setText(this.data);
        this.tf.setFont(Fonts.NORMAL_FONT);
        this.tf.setEnabled(false);

        this.panelL = new CustomJPanel();
        this.panelR = new CustomJPanel();

        MigLayout layout = new MigLayout("", "[100]5[grow]", "[grow]");

        this.setLayout(layout);

        this.add(this.nameLabel, "center");
        this.add(this.tf, "grow");

        // this.setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));
    }
}
