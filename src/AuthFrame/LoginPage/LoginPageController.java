package AuthFrame.LoginPage;

import APIConnection.APIConnection;
import AuthFrame.AuthFrameModel;
import MainFrame.CustomComponents.CustomDoubleJLabel;
import MainFrame.Navbar.NavbarModel;
import MainLoop.Loop;
import PojoClasses.Post;
import PojoClasses.User;
import Utility.PasswordHash;
import Utility.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginPageController {

    private ILoginPageView view;
    private LoginPageModel model;

    private Loop mainLoop ;

    private AuthFrameModel ref;

    public LoginPageController(LoginPageModel model, ILoginPageView view, AuthFrameModel ref)
    {
        this.mainLoop = model.getRef().getMainLoop();
        this.view = view;
        this.model = model;

        this.ref = ref;

        model.addActionListenerToLoginB( new LoginListener() );
        model.addActionListenerToRegisterB( new RegisterListener() );
        model.addActionListenerToForgotB( new ForgetPasswordListener());
    }

    class LoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    ArrayList<User> userList;

                    if(model.getUserNameTextField().getText().equals("") || model.getPasswordField().getText().equals(""))
                    {
                        PopUp popUp = new PopUp("Please fill the required spaces");
                    }
                    else
                        {
                            try
                            {
                                userList = APIConnection.getUsers();

                                String uN = model.getUserNameTextField().getText();
                                String pH = PasswordHash.hashString(model.getPasswordField().getText());

                                for (User user : userList)
                                {
                                    if(user != null && user.getUsername().equals(uN) && user.getPasswordHashed().equals(pH))
                                    {
                                        mainLoop.getMainFrameModel().setUser(user);
                                        mainLoop.getMainFrameModel().getProfilePageModel().getPPCenterModel().setUser(user);

                                        mainLoop.getMainFrameModel().getNVM().getProfLabel().setText(user.getUsername());

                                        Loop.closeFrame(mainLoop.getFrameAuth());
                                        Loop.setFrameVisible(mainLoop.getFrameMain());

                                        return;
                                    }
                                }

                                PopUp popUp = new PopUp("Username or Password is wrong please try again.");
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                                PopUp popUp = new PopUp("Please check your internet connection.");
                            }
                        }
                }
            });
        }
    }

    class RegisterListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    ref.changePage("REGISTER_PAGE");

                    model.getUserNameTextField().setText("");
                    model.getPasswordField().setText("");
                }
            });
        }
    }
    class ForgetPasswordListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    ref.changePage("PASSWORD_PAGE");

                    model.getUserNameTextField().setText("");
                    model.getPasswordField().setText("");
                }
            });
        }
    }
}
