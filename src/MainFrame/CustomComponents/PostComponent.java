package MainFrame.CustomComponents;

import PojoClasses.Post;
import Static.SizeConstants;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class PostComponent extends JComponent
{

    JLabel titleLabel;
    JLabel dateLabel;

    JLabel voteLabel;
    JLabel viewLabel;

    JLabel idLabel;

    /*******************************************************************************************/

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    /*******************************************************************************************/

    String titleText;
    String date;

    String id;

    int vote;
    int view;

    private SizeConstants sc;

    public PostComponent(Post post)
    {
        this.sc = new SizeConstants();

        this.init(post);
    }

    private void init(Post post)
    {
        this.initText(post);
        this.initLabels();
        this.initPanels();

        MigLayout layout = new MigLayout("inset 5 5 5 5", String.format("[%d][grow]", this.sc.getWIDTH_RATIO() * 15), "[grow]");
        this.setLayout(layout);

        this.panel1.add(this.viewLabel);
        this.panel1.add(this.voteLabel);

        this.panel2.add(this.titleLabel);

        this.add(this.panel1, "grow");
        this.add(this.panel2, "grow");
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
        this.titleLabel = new JLabel();
        this.titleLabel.setText(this.titleText);

        this.dateLabel = new JLabel();
        this.dateLabel.setText(this.date);

        this.voteLabel = new JLabel();
        this.voteLabel.setText("Votes: " + String.valueOf(this.vote));

        this.viewLabel = new JLabel();
        this.viewLabel.setText("Views: " + String.valueOf(this.view));

        this.idLabel = new JLabel();
        this.idLabel.setText(String.valueOf(this.id));
    }

    private void initPanels()
    {
        this.panel1 = new CustomJPanel();
        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();
    }

    public int getView()
    {
        return this.view;
    }
}
