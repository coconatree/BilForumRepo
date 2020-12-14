package AuthFrame.LoginPage;

import MainLoop.Loop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageController {

    private ILoginPageView view;
    private LoginPageModel model;
    private PageListener listener;
    private Loop mainLoop ;

    public LoginPageController(LoginPageModel model, ILoginPageView view )
    {
        this.mainLoop = model.getRef().getMainLoop();
        this.view = view;
        this.model = model;
        listener = new PageListener();
        model.addActionListenerToLoginB( listener );
        model.addActionListenerToRegisterB( listener );
    }

    class PageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if ( e.getSource() == model.getLoginButton() )
                    {
                        Loop.closeFrame( mainLoop.getFrameAuth() );
                        Loop.setFrameVisible( mainLoop.getFrameMain());
                    }
                    if ( e.getSource() == model.getRegisterButton() )
                        model.getRef().getCardLayout().show( model.getRef().getCardPanel() , "REGISTER");
                }
            });
        }
    }
}
