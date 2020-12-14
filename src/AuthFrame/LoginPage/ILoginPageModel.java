package AuthFrame.LoginPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface ILoginPageModel extends IModel
{

    void setView ( ILoginPageView view );

    CustomJPanel getView ();

    void update();
}
