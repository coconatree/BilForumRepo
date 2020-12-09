package MainFrame;

import MainFrame.CustomComponents.CustomJFrame;

public interface IMainFrameModel
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

    void setView(IMainFrameView view);

    /**
     *
     *
     */

    void update();
}
