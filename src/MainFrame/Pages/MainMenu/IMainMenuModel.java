package MainFrame.Pages.MainMenu;
import MainFrame.CustomComponents.CustomJPanel;

public interface IMainMenuModel {
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(IMainMenuView view);

    /**
     *
     *
     */

    void update();
}
