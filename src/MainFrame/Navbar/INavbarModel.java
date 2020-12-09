package MainFrame.Navbar;

import MainFrame.CustomComponents.CustomJPanel;

public interface INavbarModel
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

    void setView(INavbarView view);

    /**
     *
     *
     */

    void update();
}
