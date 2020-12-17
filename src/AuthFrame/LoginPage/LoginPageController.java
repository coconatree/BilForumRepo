package AuthFrame.LoginPage;

import MainLoop.Loop;
import PojoClasses.User;
import Utility.PasswordHash;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageController {

    private ILoginPageView view;
    private LoginPageModel model;
    private Loop mainLoop ;

    public LoginPageController(LoginPageModel model, ILoginPageView view )
    {
        this.mainLoop = model.getRef().getMainLoop();
        this.view = view;
        this.model = model;

        model.addActionListenerToLoginB( new PageListener() );
        model.addActionListenerToRegisterB( new PageListener() );
    }

    class PageListener implements ActionListener{

        String username;
        String password;

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    if ( e.getSource() == model.getLoginButton() )
                    {
                        username = model.getUserNameTextField().getText();
                        password = PasswordHash.hashString(model.getPassWordTextField().getText());

                        if(password.equals(PasswordHash.hashString("emre")))
                        {
                            mainLoop.getMainFrameModel().setUser(new User("12132", username, "", password, 1));

                            mainLoop.getMainFrameModel().getNVM().getProfLabel().setText(username);

                            Loop.closeFrame( mainLoop.getFrameAuth() );
                            Loop.setFrameVisible( mainLoop.getFrameMain());
                        }
                        else
                            {
                                System.out.println("Wrong password !!!");
                            }
                    }
                    else if ( e.getSource() == model.getRegisterButton() )
                    {
                        model.getRef().getCardLayout().show( model.getRef().getCardPanel() , "REGISTER");
                    }
                }
            });
        }
    }
}
