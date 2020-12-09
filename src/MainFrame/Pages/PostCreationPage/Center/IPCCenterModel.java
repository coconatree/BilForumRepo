package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IPCCenterModel extends IModel
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

    void setView(IPCCenterView view);

    /**
     *
     *
     */

    void update();

}

