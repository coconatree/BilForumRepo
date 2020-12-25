package AuthFrame.RegisterPage;

import APIConnection.APIConnection;
import AuthFrame.AuthFrameModel;
import PojoClasses.User;
import Utility.*;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterPageController {

    IRegisterPageView registerPageView;
    RegisterPageModel registerPageModel;

    AuthFrameModel ref;

    public RegisterPageController(IRegisterPageView registerPageView, RegisterPageModel registerPageModel, AuthFrameModel ref)
    {
        this.registerPageModel = registerPageModel;
        this.registerPageView = registerPageView;

        this.ref = ref;

        this.registerPageModel.addActionListenerToBtn(new RegisterButtonListener());
        this.registerPageModel.addActionListenerToLBtn(new LoginButtonListener());
    }

    class LoginButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    ref.changePage("LOGIN_PAGE");

                    registerPageModel.getUsernameF().setText("");
                    registerPageModel.getEmailF().setText("");
                    registerPageModel.getPasswordF().setText("");
                    registerPageModel.getPasswordRF().setText("");
                }
            });
        }
    }

    class RegisterButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(() -> {
                try
                {
                    User newUser;

                    ArrayList<User> userList = APIConnection.getUsers();

                    if(Utility.checkEmail(registerPageModel.getEmailF().getText()))
                    {
                        PopUp popUp = new PopUp("Please use your Bilkent email.");
                        return;
                    }
                    else if(registerPageModel.getUsernameF().getText().length() <= 5)
                    {
                        PopUp popUp = new PopUp("Username must be at least 5 characters.");
                        return;
                    }
                    else if(!(registerPageModel.getPasswordF().getText().equals(registerPageModel.getPasswordRF().getText())))
                    {
                        PopUp popUp = new PopUp("Passwords must match.");
                        return;
                    }
                    else {}

                    for (User user : userList)
                    {
                        if(user.getUsername().equals(registerPageModel.getUsernameF().getText()))
                        {
                            PopUp popUp = new PopUp("Username taken please select another one.");
                            return;
                        }
                        else { continue; }
                    }

                    String ID = APIConnection.getID("User-");

                    newUser = new User(
                            ID,
                            registerPageModel.getUsernameF().getText(),
                            registerPageModel.getEmailF().getText(),
                            PasswordHash.hashString(registerPageModel.getPasswordF().getText()),
                            1
                    );

                    EmailCodeGenerator generator = new EmailCodeGenerator();

                    String code = generator.createEmailCode();

                    EmailSender.send(code, registerPageModel.getEmail().getText());

                    ref.getEmailPageModel().setNewUser(newUser);
                    ref.getEmailPageModel().setCode(code);

                    ref.changePage("EMAIL_PAGE");
                }
                catch (Exception exception)
                {
                    PopUp popUp = new PopUp("Please check you internet connection.");
                    exception.printStackTrace();

                    ref.changePage("EMAIL_PAGE");
                }

                /**
                 *
                 *
                 *
                 *                 String code = new EmailCodeGenerator().createEmailCode();
                 *                 EmailSender sender = null;
                 *                 try
                 *                 {
                 *                     sender = new EmailSender(code, email);
                 *                 }
                 *                 catch (MessagingException messagingException)
                 *                 {
                 *                     messagingException.printStackTrace();
                 *                 }
                 *
                 *                 String passCode = sender.getCode();
                 *
                 *                 //also check for email
                 *
                 *
                 * */
            });
        }
    }
}
