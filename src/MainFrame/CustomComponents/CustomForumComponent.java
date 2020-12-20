package MainFrame.CustomComponents;

import PojoClasses.Forum;
import PojoClasses.Post;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class CustomForumComponent extends JComponent
{
    private Forum forum;

    private JPanel panel1;
    private JPanel panel2;

    private CustomDoubleJLabel doubleLabel1;
    private JLabel label2;
    private JLabel label3;

    public CustomForumComponent(Forum forum)
    {
        super();

        this.forum = forum;

        this.init(this.forum);

        MigLayout layout = new MigLayout("", "[70]5[grow]", "[grow]");
        this.setLayout(layout);
        this.add(this.panel1, "grow");
        this.add(this.panel2, "grow");
    }

    private void init(Forum forum)
    {
        System.out.println(forum.getId());

        this.panel1 = new CustomJPanel();
        this.doubleLabel1 = new CustomDoubleJLabel("12", "Size");

        MigLayout layout1 = new MigLayout("", "[grow]", "[grow]");

        this.panel1.setLayout(layout1);
        this.panel1.add(this.doubleLabel1, "grow, wrap");

        this.panel2 = new CustomJPanel();

        this.label2 = new CustomJLabel();
        this.label2.setText(forum.getName());
        this.label2.setFont(Fonts.TITLE_FONT);

        this.label3 = new CustomJLabel();
        this.label3.setText("SUMMARY WILL BE HERE");

        MigLayout layout2 = new MigLayout("", "[grow]","[grow]5[grow]");
        this.panel2.setLayout(layout2);

        this.panel2.add(this.label2, "center, wrap");
        this.panel2.add(this.label3, "center");
    }

    public Forum getForum()
    {
        return forum;
    }
}
