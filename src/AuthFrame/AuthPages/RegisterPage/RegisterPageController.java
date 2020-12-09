package AuthFrame.AuthPages.RegisterPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            SwingUtilities.invokeLater(() -> {
                username = registerPageModel.getUsernameF().getText();
                email = registerPageModel.getUsernameF().getText();
                password = registerPageModel.getPasswordF().getText();

                if(registerPageModel.getPasswordF().getText().equals(registerPageModel.getPasswordRF().getText()))
                {
                    valid = true;
                }
                else
                {
                    new JOptionPane("Please enter same passwords");
                }
                if(valid)
                {
                    System.out.println("Sending to the database !!!");
                    System.out.println("Redirecting you to the mail authentication page !!!");
                    System.out.println("-------------------------");

                }
                else
                {
                    System.out.println("Else block");
                    new JOptionPane("It is not valid.");
                }
            });
        }
    }


}
