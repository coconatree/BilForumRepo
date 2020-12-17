package AuthFrame.RegisterPage;

import MainFrame.CustomComponents.*;
import Static.AuthSizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterPageModel implements IRegisterPageModel
{
    private AuthSizeConstants sc;
    private IRegisterPageView registerPageView;

    private CustomJPanel panel1;
    private CustomJPanel panel2;
    private CustomJPanel panel3;
    private CustomJPanel panel4;
    private CustomJPanel panel5;

    private CustomJPanel generalPanel;

    private CustomJLabel username;
    private CustomJLabel email;
    private CustomJLabel password;
    private CustomJLabel passwordR;

    private CustomJTextField usernameF;
    private CustomJTextField emailF;
    private CustomPasswordField passwordF;
    private CustomPasswordField passwordRF;

    private CustomJButton registerBTN;

    public RegisterPageModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new AuthSizeConstants();

        this.username = new CustomJLabel();
        this.username.setText("Username:");

        this.email = new CustomJLabel();
        this.email.setText("Email:");

        this.password = new CustomJLabel();
        this.password.setText("Password:");

        this.passwordR = new CustomJLabel();
        this.passwordR.setText("Password Repeat:");

        this.usernameF = new CustomJTextField(5);

        this.emailF = new CustomJTextField(5);

        this.passwordF = new CustomPasswordField(5);

        this.passwordRF = new CustomPasswordField(5);

        this.registerBTN = new CustomJButton();
        this.registerBTN.setText("Register");

        this.initPanels();
    }

    private void initPanels()
    {
        this.panel1 = new CustomJPanel();
        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();
        this.panel4 = new CustomJPanel();
        this.panel5 = new CustomJPanel();

        this.generalPanel = new CustomJPanel();
    }

    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel) this.registerPageView;
    }

    @Override
    public void setView(IRegisterPageView view)
    {
        this.registerPageView = view;
    }

    @Override
    public void update()
    {
        this.registerPageView.update(this);
    }

    /****************************************************************************/

    public void addActionListenerToBtn(ActionListener AL)
    {
        this.getRegisterBTN().addActionListener(AL);
    }

    public AuthSizeConstants getSc() {
        return sc;
    }

    /****************************************************************************/

    public CustomJPanel getPanel1() {
        return this.panel1;
    }

    public CustomJPanel getPanel2() {
        return this.panel2;
    }

    public CustomJPanel getPanel3() {
        return this.panel3;
    }

    public CustomJPanel getPanel4() {
        return this.panel4;
    }

    public CustomJPanel getPanel5()
    {
        return this.panel5;
    }

    public CustomJPanel getGeneralPanel() {
        return generalPanel;
    }


    /****************************************************************************/
    public JButton getRegisterBTN() {
        return registerBTN;
    }

    public JLabel getUsername() {
        return username;
    }

    public JLabel getEmail() {
        return email;
    }

    public JLabel getPassword() {
        return password;
    }

    public JLabel getPasswordR() {
        return passwordR;
    }

    public JTextField getUsernameF() {
        return usernameF;
    }

    public JTextField getEmailF() {
        return emailF;
    }

    public JTextField getPasswordF() {
        return passwordF;
    }

    public JTextField getPasswordRF() {
        return passwordRF;
    }




}
