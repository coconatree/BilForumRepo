package MainFrame.Pages.ProfilePage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;
import MainFrame.Pages.PostCreationPage.IPostCreationPageView;

public interface IProfilePageModel extends IModel {
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(IProfilePageView view);

    /**
     *
     *
     */

    void update();
}
