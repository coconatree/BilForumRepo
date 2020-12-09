package AuthFrame;

import MainFrame.CustomComponents.CustomJFrame;
import MainFrame.IModel;

public interface IAuthFrameModel extends IModel
{
    /**
     *
     *
     */

    CustomJFrame getView();

    /**
     *
     *
     */

    void setView(IAuthFrameView view);

    /**
     *
     *
     */

    void update();
}
