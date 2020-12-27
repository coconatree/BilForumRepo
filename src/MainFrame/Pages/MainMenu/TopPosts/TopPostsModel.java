package MainFrame.Pages.MainMenu.TopPosts;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.PostComponent;
import MainFrame.CustomComponents.PostComponent_2;
import MainFrame.MainFrameModel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.MainMenu.TopPosts.Post_2.PostView_2;
import Static.ConstantText;
import Static.Fonts;
import Static.SizeConstants;
import PojoClasses.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    private MainFrameModel ref;
    private TopPostsModel topPostModel;

    /*******************************************************************************************/

    public TopPostsModel(MainFrameModel ref)
    {
        this.ref = ref;
        this.topPostModel = this;
        this.init();
    }

    public void init()
    {
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
            PostComponent_2 comp = new PostComponent_2(post);

            comp.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            ref.changePage("POST_PAGE", post.getContent(), post);
                        }
                    });
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

            this.comp.add(comp);
        }
    }

    /*******************************************************************************************/

    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel)(topPostsView);
    }

    @Override
    public void setView(ITopPostsView view)
    {
        this.topPostsView = view ;
    }

    @Override
    public void update()
    {
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
