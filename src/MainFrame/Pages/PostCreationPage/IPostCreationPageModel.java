package MainFrame.Pages.PostCreationPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IPostCreationPageModel extends IModel
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

    void setView(IPostCreationPageView view);

    /**
     *
     *
     */

    void update();
}
