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

    CustomDoubleJLabel customDLabel1;
    CustomDoubleJLabel customDLabel2;

    JPanel panel3;

    /*******************************************************************************************/

    String titleText;
    String date;

    String id;

    String vote;
    String view;

    private SizeConstants sc;

    public PostComponent(Post post)
    {
        super();
        this.sc = new SizeConstants();
        this.init(post);
    }

    private void init(Post post)
    {
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
    }

    private void initPanels()
    {
        this.customDLabel1 = new CustomDoubleJLabel(this.view, "Views");
        this.customDLabel2 = new CustomDoubleJLabel(this.vote, "Votes");

        this.panel3 = new JPanel();

        MigLayout layout3 = new MigLayout("", "[grow]", "[grow]");
        this.panel3.setLayout(layout3);
        this.panel3.add(this.titleLabel, "center");
    }

    public String getView()
    {
        return this.view;
    }
}
