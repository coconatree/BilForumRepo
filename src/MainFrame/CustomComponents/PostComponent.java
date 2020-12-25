package MainFrame.CustomComponents;

import PojoClasses.Post;
import Static.Fonts;
import Static.SizeConstants;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class PostComponent extends JComponent
{

    CustomJLabel titleLabel;

    /*******************************************************************************************/

    private CustomDoubleJLabel customDLabel1;
    private CustomDoubleJLabel customDLabel2;

    private JPanel panel3;

    private JLabel tags;

    /*******************************************************************************************/

    private String titleText;
    private String date;

    private String id;

    private String vote;
    private String view;

    private SizeConstants sc;

    private Post post;

    public PostComponent(Post post)
    {
        super();

        this.post = post;

        this.sc = new SizeConstants();
        this.init(post);
    }

    private void init(Post post)
    {
        this.tags = new CustomJLabel();

        this.initText(post);
        this.initLabels();
        this.initPanels();



        MigLayout layout = new MigLayout("", String.format("[%d][%d][grow]", this.sc.getWIDTH_RATIO() * 7, this.sc.getWIDTH_RATIO() * 7), "[grow]");
        this.setLayout(layout);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.add(this.customDLabel1, "grow");
        this.add(this.customDLabel2, "grow");
        this.add(this.panel3, "center, grow");
    }

    private void initText(Post post)
    {
        this.titleText = post.getTitle();
        this.date = post.getDate();

        this.id = post.getId();

        this.vote = post.getVotes();
        this.view = post.getViews();
    }

    private void initLabels()
    {
        this.titleLabel = new CustomJLabel();
        this.titleLabel.setText(this.titleText);
        this.titleLabel.setFont(Fonts.TITLE_FONT);
        this.tags.setText(this.post.getTags());
    }

    private void initPanels()
    {
        this.customDLabel1 = new CustomDoubleJLabel(this.view, "Views");
        this.customDLabel2 = new CustomDoubleJLabel(this.vote, "Votes");

        this.panel3 = new JPanel();

        MigLayout layout3 = new MigLayout("", "[grow]", String.format("[grow]5[%d]", this.sc.getHEIGHT_RATIO() * 3));
        this.panel3.setLayout(layout3);
        this.panel3.setOpaque(false);
        this.panel3.add(this.titleLabel, "center, wrap");
        this.panel3.add(this.tags, "center");
    }

    public String getView()
    {
        return this.view;
    }

    public Post getPost()
    {
        return this.post;
    }
}
