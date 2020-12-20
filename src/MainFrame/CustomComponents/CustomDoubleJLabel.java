package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;


public class CustomDoubleJLabel extends JComponent
{
    private JLabel topLabel;
    private JLabel botLabel;

    private JPanel topPanel;
    private JPanel botPanel;

    public CustomDoubleJLabel(String top, String bot)
    {
        super();
        this.init(top, bot);

        MigLayout layout1 = new MigLayout("", "[grow]", "[grow][grow]");
        this.setLayout(layout1);

        this.add(this.topPanel, "grow, wrap");
        this.add(this.botPanel, "grow");

        this.setOpaque(true);
    }

    public void init(String top, String bot)
    {
        this.topLabel = new JLabel();
        this.topLabel.setText(top);
        this.topLabel.setFont(Fonts.TITLE_FONT);

        this.botLabel = new JLabel();
        this.botLabel.setText(bot);
        this.botLabel.setFont(Fonts.NORMAL_FONT);

        MigLayout layout2 = new MigLayout("", "[grow]", "[grow]");

        this.topPanel = new JPanel();
        this.topPanel.setLayout(layout2);
        this.topPanel.add(this.topLabel, "center");

        MigLayout layout3 = new MigLayout("", "[grow]", "[grow]");

        this.botPanel = new JPanel();
        this.botPanel.setLayout(layout3);
        this.botPanel.add(this.botLabel, "center");
    }

}
