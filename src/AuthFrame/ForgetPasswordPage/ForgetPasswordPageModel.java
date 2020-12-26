package AuthFrame.ForgetPasswordPage;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.CustomJTextField;
import PojoClasses.User;
import Static.AuthSizeConstants;
import Static.Fonts;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ForgetPasswordPageModel implements IForgetPasswordPageModel{

    private AuthSizeConstants sc;
    private IForgetPasswordPageView forgetPasswordPageView;

    private CustomJPanel panel1;
    private CustomJPanel panel2;
    private CustomJPanel panel3;


    private CustomJPanel generalPanel;

    private CustomJLabel email;
    private CustomJLabel code;

    private CustomJTextField emailF;
    private CustomJTextField codeF;

    private JButton sendBTN;
    private JButton codeBTN;

    private Boolean checkMail;
    private String code1;
    private User user;

    public ForgetPasswordPageModel()
    {
        this.init();
    }
    private void init() {
        this.sc = new AuthSizeConstants();

        this.checkMail = false;
        this.email = new CustomJLabel();
        this.getEmail().setText("Your Email:");
        this.getEmail().setFont(Fonts.TITLE_FONT);
        this.getEmail().setFont(Fonts.TITLE_FONT);

        this.code = new CustomJLabel();
        this.getCode().setText("Code:");
        this.getCode().setFont(Fonts.TITLE_FONT);
        this.getCode().setFont(Fonts.TITLE_FONT);

        this.emailF = new CustomJTextField(5);
        this.codeF = new CustomJTextField(5);

        this.sendBTN = new CustomJButton();
        this.codeBTN = new CustomJButton();

        this.getSendBTN().setText("Send a code");
        this.getSendBTN().setFont(Fonts.TITLE_FONT);
        this.getSendBTN().setFont(Fonts.TITLE_FONT);

        this.getCodeBTN().setText("Send a new password");
        this.getCodeBTN().setFont(Fonts.TITLE_FONT);
        this.getCodeBTN().setFont(Fonts.TITLE_FONT);

        this.initPanels();

    }

    private void initPanels()
    {
        this.panel1 = new CustomJPanel();
        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();


        this.generalPanel = new CustomJPanel();
    }
        @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel) this.getForgetPasswordPageView();
    }

    @Override
    public void setView(IForgetPasswordPageView view) {
    this.forgetPasswordPageView = view;
    }

    @Override
    public void update() {
    this.getForgetPasswordPageView().update(this);
    }

    public void addActionListenerToBtn(ActionListener AL)
    {
        this.getSendBTN().addActionListener(AL);
    }

    public void addActionListenerToLBtn(ActionListener AL){ this.getCodeBTN().addActionListener(AL);}

    public AuthSizeConstants getSc() {
        return sc;
    }

    public CustomJPanel getPanel1() {
        return this.panel1;
    }

    public CustomJPanel getPanel2() {
        return this.panel2;
    }
    public CustomJPanel getGeneralPanel() {
        return generalPanel;
    }


    public IForgetPasswordPageView getForgetPasswordPageView() {
        return forgetPasswordPageView;
    }

    public CustomJLabel getEmail() {
        return email;
    }

    public CustomJTextField getEmailF() {
        return emailF;
    }

    public JButton getSendBTN() {
        return sendBTN;
    }

    public CustomJPanel getPanel3() {
        return panel3;
    }

    public CustomJLabel getCode() {
        return code;
    }

    public CustomJTextField getCodeF() {
        return codeF;
    }

    public JButton getCodeBTN() {
        return codeBTN;
    }

    public Boolean getCheckMail() {
        return checkMail;
    }

    public void setCheckMail(Boolean checkMail) {
        this.checkMail = checkMail;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
