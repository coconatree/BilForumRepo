package AuthFrame.ForgetPasswordPage;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.IModel;

public interface IForgetPasswordPageModel extends IModel {
    /**
     *
     *
     */

    CustomJPanel getView();

    /**
     *
     *
     */

    void setView(IForgetPasswordPageView view);

    /**
     *
     *
     */

    void update();
}
