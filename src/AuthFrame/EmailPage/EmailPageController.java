package AuthFrame.EmailPage;

import APIConnection.APIConnection;
import AuthFrame.AuthFrameModel;
import MainLoop.Loop;
import Utility.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailPageController {
    private IEmailPageView view;
    private EmailPageModel model;


    private AuthFrameModel ref;

    public EmailPageController(EmailPageModel model, IEmailPageView view, AuthFrameModel ref) {

        this.view = view;
        this.model = model;

        this.ref = ref;

        this.model.addActionListenerToVerifyB(new PageListener());
    }

    class PageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    if(model.getCode().equals(model.getCodeTextField().getText())) {
                        try {
                            APIConnection.addUser(model.getNewUser());
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        ref.changePage("LOGIN_PAGE");
                        PopUp popUp = new PopUp("Your account has been created.");

                    }
                    else
                        {
                            PopUp popUp = new PopUp("You have entered wrong code.");

                        }

                }
            });
        }
    }
}