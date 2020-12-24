package AuthFrame.EmailPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IEmailPageModel extends IModel {
    void setView ( IEmailPageView view );
    CustomJPanel getView ();
    void update();
}
