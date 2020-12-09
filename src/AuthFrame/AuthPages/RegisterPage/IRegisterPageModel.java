package AuthFrame.AuthPages.RegisterPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IRegisterPageModel extends IModel {
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(IRegisterPageView view);

    /**
     *
     *
     */

    void update();
}
