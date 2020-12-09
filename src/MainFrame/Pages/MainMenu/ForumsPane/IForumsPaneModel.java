package MainFrame.Pages.MainMenu.ForumsPane;

import MainFrame.CustomComponents.CustomJPanel;

public interface IForumsPaneModel {

    void update();

    void setView( IForumsPaneView view);

    CustomJPanel getView();


}
