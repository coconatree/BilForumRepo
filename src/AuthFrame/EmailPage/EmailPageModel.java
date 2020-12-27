package AuthFrame.EmailPage;

import AuthFrame.AuthFrameModel;
import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import PojoClasses.User;
import Static.AuthSizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmailPageModel implements IEmailPageModel
{

    private User newUser;

    private AuthSizeConstants sc ;
    private IEmailPageView emailPageView ;
    private AuthFrameModel ref ;

    private CustomJPanel panel;
    private CustomJPanel panel2;
    private CustomJPanel panel3;

    private JPanel panelTop;
    private JPanel panelBot;

    private JLabel codeLabel ;
    private JTextField codeTextField ;

    private JButton codeVerifyButton ;

    private String code;

    public EmailPageModel( ) {
        this.init();
    }

    private void init() {
        sc = new AuthSizeConstants();

        this.panel = new CustomJPanel();
        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();

        this.ref = ref ;

        codeLabel = new CustomJLabel();
        codeLabel.setText("Please enter the code to verify your email:");
        codeLabel.setFont( new Font( "Monaco", Font.BOLD, 10));

        codeTextField = new JTextField(5);

        codeVerifyButton = new CustomJButton();
        codeVerifyButton.setText("Verify");

        this.panelTop = new JPanel();
        this.panelTop.setOpaque(false);

        this.panelBot = new JPanel();
        this.panelBot.setOpaque(false);
    }

    public void setNewUser(User user){ this.newUser = user; }

    public void setCode(String code){ this.code = code; }

    @Override
    public void setView(IEmailPageView view) {
        this.emailPageView = view;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel)this.emailPageView;
    }

    @Override
    public void update() {
        emailPageView.update( this );
    }

    public void addActionListenerToVerifyB(ActionListener AL )
    {
        this.codeVerifyButton.addActionListener( AL );
    }

    public AuthSizeConstants getSc() { return sc; }

    public IEmailPageView getEmailPageView() { return emailPageView; }

    public AuthFrameModel getRef() { return ref; }

    public CustomJPanel getPanel() { return panel; }

    public CustomJPanel getPanel2() { return panel2; }

    public JLabel getCodeLabel() { return codeLabel; }

    public JTextField getCodeTextField() { return codeTextField; }

    public JButton getCodeVerifyButton() { return codeVerifyButton; }

    public CustomJPanel getPanel3() { return panel3;}

    public JPanel getPanelTop() { return panelTop; }

    public JPanel getPanelBot() {return panelBot; }

    public User getNewUser() {
        return newUser;
    }

    public String getCode() {
        return code;
    }
}
