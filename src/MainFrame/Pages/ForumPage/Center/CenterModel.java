package MainFrame.Pages.ForumPage.Center;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.ForumPage.Center.Post.PostView;
import Static.SizeConstants;
import PojoClasses.Post;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CenterModel implements ICenterModel
{
    private ICenterView centerView;
    private SizeConstants sc;

    /*******************************************************************************************/

    private ArrayList<PostModel> postModels;

    /*******************************************************************************************/

    private List<Post> postList;

    private PostView  loopView;
    private PostModel loopModel;

    public CenterModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.postModels = new ArrayList<>();

        this.postList = null;

        this.initPostList();
    }

    public void initPostList()
    {
        try
        {
            this.postList = APIConnection.httpGET();
            System.out.println("CAME");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();

            // Error Page Caller will be here

            return;
        }

        this.postModels.clear();

        this.loopView = null;
        this.loopModel = null;

        System.out.println("INSIDE THE INIT ARRAY");

        for(int i = 0; i < 10; i++)
        {
            this.loopView =  new PostView();
            this.loopModel = new PostModel(postList.get(i));

            this.loopModel.setView(this.loopView);

            this.postModels.add(this.loopModel);
        }
    }

    /*******************************************************************************************/

    public void addMouseListener(MouseListener ML)
    {
        for (PostModel mdl : this.getPostModels())
        {
            if(mdl.getPostComponent().getMouseListeners().length == 0)
            {
                mdl.getPostComponent().addMouseListener(ML);
            }
        }
    }

    /*******************************************************************************************/


    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel) this.centerView;
    }

    @Override
    public void setView(ICenterView view)
    {
        this.centerView = view;
    }

    @Override
    public void update()
    {
        this.initPostList();
        this.centerView.update(this);

        for (PostModel mdl : this.postModels)
        {
            mdl.getPostComponent().revalidate();
            mdl.getPostComponent().repaint();
        }
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

    /*******************************************************************************************/

    public void setPostModels(ArrayList<PostModel> postModels)
    {
        this.postModels = postModels;
    }
}
