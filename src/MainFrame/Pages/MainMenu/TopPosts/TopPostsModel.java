package MainFrame.Pages.MainMenu.TopPosts;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.PostComponent_2;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.MainMenu.TopPosts.Post_2.PostView_2;
import Static.ConstantText;
import Static.Fonts;
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

    private ArrayList<Post> topPosts;
    private ArrayList<PostComponent_2> comp;

    /*******************************************************************************************/

    public TopPostsModel()
    {
        this.init();
    }

    public void init(){

        sc = new SizeConstants();

        topPosts = new ArrayList<Post>();

        comp = new ArrayList<PostComponent_2>();

        topPostsLabel = new CustomJLabel();
        topPostsLabel.setText(ConstantText.getTopPostsText());
        topPostsLabel.setFont(Fonts.TITLE_FONT);

        try
        {
            this.topPosts = APIConnection.getTop10Post();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        for (Post post : this.topPosts)
        {
            this.comp.add(new PostComponent_2(post));
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

    public ArrayList<PostComponent_2> getCMP()
    {
        return this.comp;
    }

    public JLabel getTopPostsLabel()
    {
        return this.topPostsLabel ;
    }

    /*******************************************************************************************/
}
