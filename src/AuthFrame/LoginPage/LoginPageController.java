package AuthFrame.LoginPage;

import APIConnection.APIConnection;
import MainLoop.Loop;
import PojoClasses.Post;
import PojoClasses.User;
import Utility.PasswordHash;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
        String passwordCheck;

        //api yoksa bunu true yapıp direk girebilirsiniz.

        boolean valid = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    if ( e.getSource() == model.getLoginButton() )
                    {
                        passwordCheck = model.getPasswordField().getText();
                        username = model.getUserNameTextField().getText();
                        password = PasswordHash.hashString(model.getPasswordField().getText());
                        List<User> userList;
                        try {
                            userList = APIConnection.getUsers();
                            System.out.println(userList);
                            for(int i = 0; i < userList.size(); i++)
                            {
                                if(userList.get(i).getUsername().equals(username))
                                {
                                    if(userList.get(i).getPasswordHashed().equals(passwordCheck))
                                    {
                                        valid = true;
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }


                        if(valid)
                        {
                            User user = new User("", username, "", password, 1);

                            mainLoop.getMainFrameModel().setUser(user);
                            mainLoop.getMainFrameModel().getProfilePageModel().getPPCenterModel().setUser(user);

                            System.out.println(user.toString());

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
