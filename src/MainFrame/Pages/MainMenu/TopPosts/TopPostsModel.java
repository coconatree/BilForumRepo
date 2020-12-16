package MainFrame.Pages.MainMenu.TopPosts;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.MainMenu.TopPosts.Post_2.PostView_2;
import Static.ConstantText;
import Static.SizeConstants;
import PojoClasses.Post;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * __The model class of Top Posts Pane in the main menu (Left Pane) ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */

public class TopPostsModel implements ITopPostsModel{

    private ITopPostsView topPostsView;
    private SizeConstants sc ;

    private JLabel topPostsLabel ;
    /*******************************************************************************************/

    private ArrayList<PostModel> postModels;

    /*******************************************************************************************/

    public TopPostsModel()
    {
        this.init();
    }

    public void init(){

        sc = new SizeConstants();
        postModels = new ArrayList<PostModel>();
        topPostsLabel = new JLabel(ConstantText.getTopPostsText());
        topPostsLabel.setFont( new Font(Font.SERIF,Font.BOLD, 25));
        topPostsLabel.setForeground( new Color(0,150,50));

        PostView_2 loopView;
        PostModel loopModel;

        for ( int i = 0 ; i < 10 ; i++)
        {
            int random = (int)(Math.random() * 100);

            loopModel = new PostModel( new Post("Hi my problem is :" + i , "12", "12", "", "", "", "", ""));
            loopView = new PostView_2();

            loopModel.setView( loopView );

            this.postModels.add(loopModel);
        }
    }

    /*******************************************************************************************/

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel)(topPostsView);
    }

    @Override
    public void setView(ITopPostsView view) {
        this.topPostsView = view ;
    }

    @Override
    public void update() {
        this.topPostsView.update( this );
    }
    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return sc;
    }

    public ArrayList<PostModel> getPostModels()
    {
        return postModels;
    }

    public JLabel getTopPostsLabel()
    {
        return this.topPostsLabel ;
    }

    /*******************************************************************************************/

    public void setPostModels(ArrayList<PostModel> postModels)
    {
        this.postModels = postModels;
    }
}
