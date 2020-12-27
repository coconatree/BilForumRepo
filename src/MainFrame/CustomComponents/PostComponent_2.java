package MainFrame.CustomComponents;

import PojoClasses.Post;
import Static.Colors;
import Static.SizeConstants;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class PostComponent_2 extends JComponent {

    private JLabel titleLabel ;
    private JLabel voteLabel ;

    /*****************************************************************/

    private SizeConstants sc ;
    private JPanel panel ;

    String view ;
    String title ;

    public PostComponent_2(Post post)
    {

        this.initText(post);
        this.initLabels();
        panel = new JPanel();
        this.panel.setOpaque(false);

        MigLayout layout = new MigLayout( "inset 0 0 0 0", "[grow]" , "[grow]");
        this.setLayout( layout );

        MigLayout layout1 = new MigLayout("", "[grow]5[70]", "[grow]");

        this.panel.setLayout(layout1);

        panel.add( titleLabel, "grow");
        panel.add( voteLabel , "grow");

        this.add( this.panel , "grow");

        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.SECONDARY_COLOR));
    }

    public void initText( Post post){

        this.view = post.getViews();
        this.title = post.getTitle();
    }

    public void initLabels(){

        titleLabel = new JLabel();
        titleLabel.setText("Title: " + this.title);

        voteLabel = new JLabel();
        voteLabel.setText("Views : " + String.valueOf(this.view));
    }

}
