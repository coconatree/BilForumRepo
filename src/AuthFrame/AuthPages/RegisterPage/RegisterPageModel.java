package AuthFrame.AuthPages.RegisterPage;

import MainFrame.CustomComponents.CustomJPanel;
import Static.AuthSizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterPageModel implements IRegisterPageModel {


    private AuthSizeConstants sc;
    private IRegisterPageView registerPageView;

    private CustomJPanel panel1;

    private JLabel username;
    private JLabel email;
    private JLabel password;
    private JLabel passwordR;

    private JTextField usernameF;
    private JTextField emailF;
    private JTextField passwordF;
    private JTextField passwordRF;

    private JButton registerBTN;

    public RegisterPageModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new AuthSizeConstants();

        username = new JLabel("Username");
        email = new JLabel("Email");
        password = new JLabel("Password");
        passwordR = new JLabel("Password Repeat");

        usernameF = new JTextField(10);
        emailF = new JTextField(10);
        passwordF = new JTextField(10);
        passwordRF = new JTextField(10);

        this.panel1 = new CustomJPanel();
        this.getPanel1().setBackground(Color.MAGENTA);

        this.registerBTN = new JButton("Register");
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
        return panel1;
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
