package MainFrame.Pages.MainMenu.ForumsPane;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.MainMenu.ForumsPane.Forum.ForumModel;
import MainFrame.Pages.MainMenu.ForumsPane.Forum.ForumView;
import Static.SizeConstants;
import PojoClasses.Post;
import PojoClasses.Forum;

import java.util.ArrayList;

public class ForumsPaneModel implements IForumsPaneModel{

    private SizeConstants sc ;
    private IForumsPaneView forumsPaneView;

    /*******************************************************************************************/

    private ArrayList<ForumModel> forumList;

    /*******************************************************************************************/

    public ForumsPaneModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();
        this.forumList = new ArrayList<ForumModel>();

        ArrayList<Post> postList = new ArrayList<>(); // Sample ArrayList of Post object
        Post loopPost;

        for (int i = 0 ; i < 15 ; i++)
        {
            loopPost = new Post("Hello ",12,12,"", "", "","");
            postList.add( loopPost );
        }

        ForumModel loopModel;
        ForumView loopView ;

        for ( int i = 0 ; i < 10 ; i++)
        {
            loopView = new ForumView();
            loopModel = new ForumModel( new Forum( "Forum Title" + i, postList,(i + 1) + ".11.2020" ));

            loopModel.setView( loopView );
            forumList.add( loopModel );
        }
    }

    /*******************************************************************************************/

    @Override
    public void update() {
        this.forumsPaneView.update( this );
    }

    @Override
    public void setView(IForumsPaneView view) {
        this.forumsPaneView = view ;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel) forumsPaneView;
    }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    public IForumsPaneView getForumsPaneView() {
        return forumsPaneView;
    }

    public ArrayList<ForumModel> getForumList() {
        return forumList;
    }

    public void setForumsPaneView(IForumsPaneView forumsPaneView) {
        this.forumsPaneView = forumsPaneView;
    }

    public void setForumList(ArrayList<ForumModel> forumList) {
        this.forumList = forumList;
    }
}
