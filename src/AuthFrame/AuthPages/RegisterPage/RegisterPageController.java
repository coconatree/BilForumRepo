package AuthFrame.AuthPages.RegisterPage;

import Utility.EmailCodeGenerator;
import Utility.EmailSender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                String passCode = new EmailSender(code,email).getCode();
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
                        System.out.println("new user added to the databese");
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
