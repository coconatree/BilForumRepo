package MainFrame.Pages.ForumPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.ForumPage.Center.Post.PostView;
import Static.SizeConstants;
import PojoClasses.Post;

import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CenterModel implements ICenterModel
{
    private ICenterView centerView;
    private SizeConstants sc;

    /*******************************************************************************************/

    private ArrayList<PostModel> postModels;

    /*******************************************************************************************/

    public CenterModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.postModels = new ArrayList<>();

        PostView  loopView;
        PostModel loopModel;

        for(int i = 0; i < 10; i++)
        {
            loopView =  new PostView();
            loopModel = new PostModel(new Post("emre", (int)(Math.random() * 1000), 20, "emre", "emre", "emre", "12:12:2020", ""));

            loopModel.setView(loopView);

            this.postModels.add(loopModel);
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
        this.centerView.update(this);
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
