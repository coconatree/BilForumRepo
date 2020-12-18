package MainFrame.Pages.PostPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IPostPageModel extends IModel {
    CustomJPanel getView();
    void setView(IPostPageView view);
    void update();
}
