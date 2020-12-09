package MainFrame.Pages.ForumPage.LeftBar;

import MainFrame.CustomComponents.CustomJPanel;

public interface ILeftBaModel
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

    void setView(ILeftBarView view);

    /**
     *
     *
     */

    void update();
}
