package MainFrame.Pages.ForumPage.Center;

import MainFrame.CustomComponents.CustomJPanel;

import javax.swing.*;

public interface ICenterModel
{
    /**
     *
     *
     */

    JPanel getView();

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
