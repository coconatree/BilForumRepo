package MainFrame.Pages.ForumPage.Center.Post;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.PostComponent;
import MainFrame.CustomComponents.PostComponent_2;
import PojoClasses.Post;
import Static.SizeConstants;

import java.awt.event.MouseListener;

public class PostModel implements IPostModel
{
    private IPostView postView;
    private Post obj;

    private SizeConstants sc;

    /*******************************************************************************************/

    private PostComponent postComponent;
    private PostComponent_2 postComponent_2 ;

    /*******************************************************************************************/

    public PostModel(Post post)
    {
        this.init(post);
    }

    private void init(Post post)
    {
        this.sc = new SizeConstants();

        this.postComponent = new PostComponent(post);
        this.postComponent_2 = new PostComponent_2(post);
    }

    public void addMouseListenerToComponent1(MouseListener ML)
    {
        this.postComponent.addMouseListener(ML);
        System.out.println("ADDED");
    }

    /*******************************************************************************************/

    /*******************************************************************************************/

    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel) this.postView;
    }

    @Override
    public void setView(IPostView view)
    {
        this.postView = view;
    }

    @Override
    public void update()
    {
        this.postView.update(this);
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return sc;
    }

    public PostComponent getPostComponent()
    {
        return this.postComponent;
    }

    public PostComponent_2 getPostComponent_2()
    {
        return this.postComponent_2;
    }
}
