package AuthFrame.LoginPage;

import AuthFrame.AuthFrameModel;
import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJPanel;
import Static.AuthSizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPageModel implements ILoginPageModel{

    private AuthSizeConstants sc ;
    private ILoginPageView loginPageView ;
    private AuthFrameModel ref ;

    private CustomJPanel panel ;

    private JLabel usernameLabel ;
    private JLabel passWordLabel ;

    private JTextField userNameTextField ;
    private JTextField passWordTextField ;

    private JButton loginButton ;
    private JButton registerButton ;
    private JButton forgotButton ;

    public LoginPageModel( AuthFrameModel ref)
    {
        this.init( ref );
    }

    private void init( AuthFrameModel ref)
    {
        sc = new AuthSizeConstants();
        panel = new CustomJPanel();
        this.ref = ref ;

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont( new Font( "Monaco", Font.BOLD, 20));
        passWordLabel = new JLabel("Password:");
        passWordLabel.setFont( new Font( "Monaco", Font.BOLD, 20));

        userNameTextField = new JTextField(40);
        passWordTextField = new JTextField(40);

        loginButton = new CustomJButton();
        loginButton.setText("LOG IN");
        registerButton = new CustomJButton();
        registerButton.setText("REGISTER");
        forgotButton = new CustomJButton();
        forgotButton.setText("Forgot your password?");
    }

    /*************************************************************************/
    @Override
    public void setView(ILoginPageView view) {
        this.loginPageView = view ;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel)this.loginPageView ;
    }

    @Override
    public void update() {
        loginPageView.update( this );
    }

    /*************************************************************************/

    public void addActionListenerToLoginB(ActionListener AL )
    {
        this.loginButton.addActionListener( AL );
    }

    public void addActionListenerToRegisterB(ActionListener AL )
    {
        this.registerButton.addActionListener( AL );
    }

    public void addActionListenerToForgotB(ActionListener AL )
    {
        this.forgotButton.addActionListener( AL );
    }



    /*************************************************************************/

    public AuthFrameModel getRef() {
        return ref;
    }

    public CustomJPanel getPanel() {
        return panel;
    }

    public AuthSizeConstants getSc() {
        return sc;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getForgotButton() {
        return forgotButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getPassWordLabel() {
        return passWordLabel;
    }

    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JTextField getPassWordTextField() {
        return passWordTextField;
    }
}
