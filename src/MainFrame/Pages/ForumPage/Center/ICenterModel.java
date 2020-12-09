package MainFrame.Pages.ForumPage.Center;

import MainFrame.CustomComponents.CustomJPanel;

public interface ICenterModel
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

    void setView(ICenterView view);

    /**
     *
     *
     */

    void update();

}
