package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJPanel;

public interface IPOCenterModel {
    CustomJPanel getView();
    void setView(IPOCenterView view);
    void update();
}
