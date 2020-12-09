package MainFrame.Pages.ForumPage.Center.Post;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.PostComponent;
import PojoClasses.Post;
import Static.SizeConstants;

public class PostModel implements IPostModel
{
    private IPostView postView;
    private Post obj;

    private SizeConstants sc;

    /*******************************************************************************************/

    private PostComponent postComponent;

    /*******************************************************************************************/

    public PostModel(Post post)
    {
        this.init(post);
    }

    private void init(Post post)
    {
        this.sc = new SizeConstants();

        this.postComponent = new PostComponent(post);
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
}
