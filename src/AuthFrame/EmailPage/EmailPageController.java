package AuthFrame.EmailPage;

import AuthFrame.AuthFrameModel;
import MainLoop.Loop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailPageController {
    private IEmailPageView view;
    private EmailPageModel model;
    private PageListener listener;
    private Loop mainLoop;

    private AuthFrameModel ref;

    public EmailPageController(EmailPageModel model, IEmailPageView view, AuthFrameModel ref) {
        this.mainLoop = model.getRef().getMainLoop();
        this.view = view;
        this.model = model;

        this.ref = ref;

        listener = new PageListener();
        model.addActionListenerToVerifyB(listener);
    }

    class PageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (e.getSource() == model.getCodeVerifyButton()) {
                        //Loop.closeFrame( mainLoop.getFrameAuth() );
                        //Loop.setFrameVisible(mainLoop.getFrameMain());
                        model.getRef().getCardLayout().show(model.getRef().getCardPanel(), "LOGIN_PAGE");
                    }

                }
            });
        }
    }
}