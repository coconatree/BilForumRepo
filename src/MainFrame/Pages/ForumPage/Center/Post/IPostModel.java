package MainFrame.Pages.ForumPage.Center.Post;

import MainFrame.CustomComponents.CustomJPanel;

public interface IPostModel
{
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(IPostView view);

    /**
     *
     *
     */

    void update();
}
