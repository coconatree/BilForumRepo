package AuthFrame.LoginPage;

import AuthFrame.AuthFrameModel;
import MainFrame.CustomComponents.*;
import Static.AuthSizeConstants;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPageModel implements ILoginPageModel{

    private AuthSizeConstants sc ;
    private ILoginPageView loginPageView ;
    private AuthFrameModel ref ;

    private CustomJPanel panel ;

    /*****************************************/

    private CustomJPanel panel1;
    private CustomJPanel panel2;
    private CustomJPanel panel3;
    private CustomJPanel panel4;
    private CustomJPanel panel5;

    /*****************************************/

    private JLabel usernameLabel ;
    private JLabel passWordLabel ;

    private JTextField userNameTextField ;
    private JTextField passwordField ;

    private JButton loginButton ;
    private JButton registerButton ;
    private JButton forgotButton ;

    public LoginPageModel( AuthFrameModel ref)
    {
        this.init( ref );
    }

    private void init( AuthFrameModel ref)
    {
        this.sc = new AuthSizeConstants();
        this.ref = ref ;

        this.panel1 = new CustomJPanel();
        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();
        this.panel4 = new CustomJPanel();
        this.panel5 = new CustomJPanel();

        this.usernameLabel = new CustomJLabel();
        this.usernameLabel.setText("Username:");
        this.usernameLabel.setFont(Fonts.AUTH_FONT);

        this.userNameTextField = new CustomJTextField(5);

        this.passWordLabel = new CustomJLabel();
        this.passWordLabel.setText("Password:");
        this.passWordLabel.setFont(Fonts.AUTH_FONT);

        this.passwordField = new CustomPasswordField(5);

        this.loginButton = new CustomJButton();
        this.loginButton.setText("Login");
        this.loginButton.setFont(Fonts.AUTH_FONT);

        this.registerButton = new CustomJButton();
        this.registerButton.setText("Register");
        this.registerButton.setFont(Fonts.AUTH_FONT);

        this.forgotButton = new CustomJButton();
        this.forgotButton.setText("Forgot your password?");
        this.forgotButton.setFont(Fonts.AUTH_FONT);
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

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JPanel getPanel1(){ return this.panel1; }

    public JPanel getPanel2(){ return this.panel2; }

    public JPanel getPanel3(){ return this.panel3; }

    public JPanel getPanel4(){ return this.panel4; }

    public JPanel getPanel5(){ return this.panel5; }


}
