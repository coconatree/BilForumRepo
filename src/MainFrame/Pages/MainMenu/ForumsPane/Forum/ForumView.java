package MainFrame.Pages.MainMenu.ForumsPane.Forum;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import net.miginfocom.swing.MigLayout;
/**
 * __ForumView class ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */

public class ForumView extends CustomJPanel implements IForumView
{
    @Override
    public void update(ForumModel model) {
        this.init( model );
    }

    private void init( ForumModel model){
        this.addAllComponents( model );
    }

    private void addAllComponents( ForumModel model){

        MigLayout layout = new MigLayout( "inset 5 5 5 5" , String.format("[grow]5[%d]", model.getSc().getWIDTH_RATIO() * 20),String.format("[%d]", model.getSc().getHEIGHT_RATIO() * 13));
        this.setLayout( layout );

        this.setPanel1( model );
        this.setPanel2( model );

        add( model.getPanel1(), "grow" );
        add( model.getPanel2(),"grow , wrap" );
    }

    private void setPanel1( ForumModel model){
        MigLayout layout1 = new MigLayout("inset 5 5 5 5", "[grow]" ,"[grow]");
        model.getPanel1().setLayout(layout1);

        model.getPanel1().add( model.getTitleLabel(), "grow");
    }

    private void setPanel2( ForumModel model){
        MigLayout layout2 = new MigLayout("inset 5 5 5 5", "[grow]5[grow]" ,"[grow]");
        model.getPanel2().setLayout( layout2 );

        model.getPanel2().add( model.getPostCountLabel(), "grow");
        model.getPanel2().add( model.getCreationDateLabel(), "grow");

    }
    private void setPanel3(PostModel model)
    {

    }
}
