package MainFrame.Pages.MainMenu.TopPosts.Post_2;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.IPostView;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import net.miginfocom.swing.MigLayout;

public class PostView_2 extends CustomJPanel implements IPostView
{
    @Override
    public void update(PostModel model)
    {
        this.init( model );
        this.validate();
        this.repaint();
    }

    private void init( PostModel model)
    {
        this.addAll( model );
    }

    private void addAll( PostModel model )
    {
        MigLayout layout = new MigLayout("inset 5 5 5 5", String.format("[%d]5[%d]", model.getSc().getWIDTH_RATIO() * 10,model.getSc().getWIDTH_RATIO() * 5), String.format("[%d]", model.getSc().getHEIGHT_RATIO() * 5));

        this.setLayout( layout );

        // [grow] yazmıstın grow yerine
        this.add( model.getPostComponent_2() , "grow");
        //add( model.getTitleLabel() , "grow");
        //add( model.getVoteLabel(), "grow");
    }
}
