package MainFrame.Pages.MainMenu.TopPosts;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.ICenterView;

public interface ITopPostsModel {
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(ITopPostsView view);

    /**
     *
     *
     */

    void update();
}
