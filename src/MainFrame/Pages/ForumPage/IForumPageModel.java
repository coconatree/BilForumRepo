package MainFrame.Pages.ForumPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IForumPageModel extends IModel
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

    void setView(IForumPageView view);

    /**
     *
     *
     */

    void update();
}
