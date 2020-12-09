package MainFrame.Pages.ProfilePage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IPPCenterModel extends IModel {
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(PPCenterView view);

    /**
     *
     *
     */

    void update();
}
