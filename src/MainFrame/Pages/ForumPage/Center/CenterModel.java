package MainFrame.Pages.ForumPage.Center;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.ForumPage.Center.Post.PostView;
import PojoClasses.Forum;
import Static.SizeConstants;
import PojoClasses.Post;
import Utility.SortingAlgorithms;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CenterModel implements ICenterModel
{
    private ICenterView centerView;
    private SizeConstants sc;

    /*******************************************************************************************/

    private ArrayList<PostModel> postModels;
    private SortingAlgorithms algorithms;
    /*******************************************************************************************/

    private List<Post> postList;

    private PostView  loopView;
    private PostModel loopModel;

    private Forum forum;

    public CenterModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.postModels = new ArrayList<>();

        this.postList = null;
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

    public void wake()
    {
        this.postList = forum.getPostList();

        PostModel tempModel = null;
        PostView tempView = null;

        this.postModels.clear();

        for(int i = 0; i < this.postList.size(); i++)
        {
            tempModel = new PostModel(this.postList.get(i));
            tempView = new PostView();

            tempModel.setView(tempView);

            this.postModels.add(tempModel);
        }

        this.update();
    }

    public void wakeVote()
    {
        this.postList = forum.getPostList();

        algorithms = new SortingAlgorithms();
        PostModel tempModel = null;
        PostView tempView = null;

        this.postModels.clear();

        algorithms.sortPostListByVotes((ArrayList<Post>) this.postList);

        for(int i = this.postList.size() - 1; i >= 0 ; i--)
        {
            tempModel = new PostModel(this.postList.get(i));
            tempView = new PostView();

            tempModel.setView(tempView);

            this.postModels.add(tempModel);
        }

        this.update();
    }

    public void wakeView()
    {
        this.postList = forum.getPostList();

        algorithms = new SortingAlgorithms();
        PostModel tempModel = null;
        PostView tempView = null;

        this.postModels.clear();

        algorithms.sortPostListByViews((ArrayList<Post>) this.postList);

        for(int i = this.postList.size() - 1; i >= 0 ; i--)
        {
            tempModel = new PostModel(this.postList.get(i));
            tempView = new PostView();

            tempModel.setView(tempView);

            this.postModels.add(tempModel);
        }

        this.update();
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

    public void setForum(Forum forum)
    {
        this.forum = forum;
        this.wake();
    }
}
