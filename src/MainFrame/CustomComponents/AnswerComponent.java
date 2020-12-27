package MainFrame.CustomComponents;

import Static.Colors;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class AnswerComponent extends JComponent
{
    private JLabel title;
    private JTextArea content;


    public AnswerComponent(String title, String content)
    {
        this.title = new CustomJLabel();
        this.title.setText(title + " 's Answer");
        this.title.setFont(Fonts.TITLE_FONT);

        this.content = new JTextArea();
        this.content.setText(content);
        this.content.setEditable(false);
        this.content.setFont(Fonts.NORMAL_FONT);
        this.content.setForeground(Colors.SECONDARY_COLOR);

        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[20]5[grow]");
        this.setLayout(layout);

        this.title.setOpaque(false);
        this.content.setOpaque(false);

        this.add(this.title, "center, wrap");
        this.add(this.content, "grow");
    }
}
