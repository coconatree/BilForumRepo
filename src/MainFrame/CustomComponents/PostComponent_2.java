package MainFrame.CustomComponents;

import PojoClasses.Post;
import Static.SizeConstants;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class PostComponent_2 extends JComponent {

    private JLabel titleLabel ;
    private JLabel voteLabel ;

    /*****************************************************************/

    private SizeConstants sc ;
    private JPanel panel ;

    String vote ;
    String title ;

    public PostComponent_2(Post post){

        this.initText(post);
        this.initLabels();
        panel = new JPanel();

        MigLayout layout = new MigLayout( "inset 5 5 5 5 ", "[grow]" , "[grow]");
        this.setLayout( layout );

        panel.add( titleLabel );
        panel.add( voteLabel );

        this.add( this.panel , "grow");
    }

    public void initText( Post post){

        vote = post.getVotes();
        title = post.getTitle();
    }

    public void initLabels(){

        titleLabel = new JLabel();
        titleLabel.setText("Title: " + title);

        voteLabel = new JLabel();
        voteLabel.setText("Votes: " + String.valueOf( vote ));
    }

}
