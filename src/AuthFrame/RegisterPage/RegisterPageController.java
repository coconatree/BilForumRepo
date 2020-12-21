package AuthFrame.RegisterPage;

import APIConnection.APIConnection;
import PojoClasses.User;
import Utility.EmailCodeGenerator;
import Utility.EmailSender;
import Utility.PasswordHash;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class RegisterPageController {

    IRegisterPageView registerPageView;
    RegisterPageModel registerPageModel;

    public RegisterPageController(IRegisterPageView registerPageView, RegisterPageModel registerPageModel)
    {
        this.registerPageModel = registerPageModel;
        this.registerPageView = registerPageView;

        this.registerPageModel.addActionListenerToBtn(new RegisterButtonListener());
    }
    class RegisterButtonListener implements ActionListener
    {
        String username;
        String email;
        String password;
        String ID;

        boolean valid = false;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Scanner scan = new Scanner(System.in);

            SwingUtilities.invokeLater(() -> {

                String input;

                username = registerPageModel.getUsernameF().getText();
                email = registerPageModel.getEmailF().getText();
                password = registerPageModel.getPasswordF().getText();

                String code = new EmailCodeGenerator().createEmailCode();
                EmailSender sender = new EmailSender(code, email);

                String passCode = sender.getCode();

                //also check for email
                if(registerPageModel.getPasswordF().getText().equals(registerPageModel.getPasswordRF().getText()))
                {
                    valid = true;
                }
                if(valid)
                {
                    input = scan.nextLine();
                    if(input.equals(code))
                    {
                        ID = new EmailCodeGenerator().createUserID();

                        User user1 = new User(
                                ID,
                                username,
                                email,
                                new PasswordHash().hashString(password),
                                1
                        );
                        try {
                            String rofl = APIConnection.httpUser(user1);

                            System.out.println(rofl);
                        }
                        catch ( Exception exception)
                        {
                            exception.printStackTrace();
                            exception.getMessage();
                        }

                    }
                    else
                    {
                        System.out.println("wrong code");
                    }
                }
            });
        }
    }
}
