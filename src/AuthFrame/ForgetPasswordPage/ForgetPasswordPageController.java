package AuthFrame.ForgetPasswordPage;

import APIConnection.APIConnection;
import AuthFrame.AuthFrameModel;
import PojoClasses.User;
import Utility.EmailCodeGenerator;
import Utility.EmailSender;
import Utility.PasswordHash;
import Utility.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ForgetPasswordPageController {

    IForgetPasswordPageView forgetPasswordPageView;
    ForgetPasswordPageModel forgetPasswordPageModel;

    AuthFrameModel ref;

    public ForgetPasswordPageController(IForgetPasswordPageView forgetPasswordPageView, ForgetPasswordPageModel forgetPasswordPageModel, AuthFrameModel ref)
    {
        this.forgetPasswordPageModel = forgetPasswordPageModel;
        this.forgetPasswordPageView = forgetPasswordPageView;

        this.ref = ref;

        this.forgetPasswordPageModel.addActionListenerToBtn(new SendButtonListener());
        this.forgetPasswordPageModel.addActionListenerToLBtn(new CodeButtonListener());

    }
    class SendButtonListener implements ActionListener
    {

        private Boolean bool;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    bool = false;
                    EmailCodeGenerator codeGenerator = new EmailCodeGenerator();
                    forgetPasswordPageModel.setCode1(codeGenerator.createEmailCode());

                    try {
                        ArrayList<User> userList = APIConnection.getUsers();

                        for(User user : userList)
                        {
                            if(user.getEmail().equals(forgetPasswordPageModel.getEmailF().getText()))
                            {
                                bool = true;
                                forgetPasswordPageModel.setUser(user);
                            }
                        }
                        if(bool)
                        {
                            EmailSender sender;
                            sender = new EmailSender(forgetPasswordPageModel.getCode1(),forgetPasswordPageModel.getEmailF().getText());
                            forgetPasswordPageModel.setCheckMail(true);
                            PopUp popUp = new PopUp("We have sent you a code");
                        }
                        else
                        {
                            forgetPasswordPageModel.setCheckMail(false);
                            PopUp popUp = new PopUp("Enter a valid e mail adress");
                        }

                    } catch (Exception exception) {
                        PopUp popUp = new PopUp("Please check your internet connection.");
                        exception.printStackTrace();
                    }

                }
            });
        }
    }
    class CodeButtonListener implements ActionListener
    {
        User user2;
        EmailCodeGenerator generator = new EmailCodeGenerator();
        String password;
        EmailSender sender = new EmailSender();
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {

                  if(forgetPasswordPageModel.getCheckMail()) {
                      if (forgetPasswordPageModel.getCode1().equals(forgetPasswordPageModel.getCodeF().getText())) {
                          user2 = forgetPasswordPageModel.getUser();
                          password = generator.createPassword();
                          user2.setPasswordHashed(PasswordHash.hashString(password));

                          try {
                              APIConnection.updateUser(user2);
                          } catch (Exception exception) {
                              exception.printStackTrace();
                              PopUp popUp = new PopUp("There is no internet");
                          }

                          sender.forgetSender(user2.getUsername(), password, user2.getEmail());

                          ref.changePage("LOGIN_PAGE");
                          forgetPasswordPageModel.getCodeF().setText("");
                          forgetPasswordPageModel.getEmailF().setText("");
                          PopUp popUp = new PopUp("We have sent your new password and current username");


                      } else {
                          PopUp popUp = new PopUp("Wrong code");
                      }

                  }
                  else
                  {
                      PopUp popUp = new PopUp("You should enter your email and ask for code");
                  }
                }
            });
        }
    }

}
