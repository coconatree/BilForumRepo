package AuthFrame;

import AuthFrame.AuthPages.RegisterPage.RegisterPageController;
import AuthFrame.AuthPages.RegisterPage.RegisterPageModel;
import AuthFrame.AuthPages.RegisterPage.RegisterPageView;
import AuthFrame.LoginPage.LoginPageController;
import AuthFrame.LoginPage.LoginPageModel;
import AuthFrame.LoginPage.LoginPageView;
import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJFrame;
import MainFrame.CustomComponents.CustomJPanel;
import MainLoop.Loop;
import Static.AuthSizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthFrameModel implements IAuthFrameModel {
    private AuthSizeConstants sc;
    private IAuthFrameView authFrameView;
    private Loop mainLoop ;

    /****************************************************************************/

    private CustomJPanel cardPanel;

    private CustomJPanel panel1;
    private CustomJPanel panel2;
    private CustomJPanel panel3;

    private CardLayout cardLayout;

    /****************************************************************************/

    private RegisterPageView RPV;
    private RegisterPageModel RPM;
    private RegisterPageController RPC;

    /****************************************************************************/

    private LoginPageView loginPageView;
    private LoginPageModel loginPageModel;
    private LoginPageController loginPageController;

    /****************************************************************************/

    private JButton btn;
    private JButton btnRegister;

    public AuthFrameModel( Loop mainLoop )
    {
        this.init( mainLoop );
    }

    private void init( Loop mainLoop )
    {
        this.sc = new AuthSizeConstants();

        this.cardPanel = new CustomJPanel();

        this.mainLoop = mainLoop ;

        this.panel1 = new CustomJPanel();
        this.panel1.setBackground(Color.YELLOW);

        this.panel2 = new CustomJPanel();
        this.panel2.setBackground(Color.MAGENTA);

        this.panel3 = new CustomJPanel();
        this.panel3.setBackground(Color.BLUE);

        this.cardLayout = new CardLayout();

        this.btn = new CustomJButton();
        this.btn.setText("Login");

        this.createLoginPage();
        this.createRegisterPage();


        this.btnRegister = new CustomJButton();
        this.btnRegister.setText("Register");
    }

    private void createLoginPage()
    {
        this.loginPageView = new LoginPageView();
        this.loginPageModel = new LoginPageModel( this );
        this.loginPageController = new LoginPageController( loginPageModel , loginPageView);

        this.loginPageModel.setView( this.loginPageView );
    }

    private void createRegisterPage()
    {
        this.RPV = new RegisterPageView();
        this.RPM = new RegisterPageModel();
        this.RPC = new RegisterPageController(this.RPV, this.RPM);

        this.RPM.setView(this.RPV);
    }

    /****************************************************************************/

    @Override
    public CustomJFrame getView()
    {
        this.update();
        return (CustomJFrame) this.authFrameView;
    }

    @Override
    public void setView(IAuthFrameView view) {
        this.authFrameView = view;
    }

    @Override
    public void update() {
        this.authFrameView.update(this);
    }

    /****************************************************************************/

    public void addActionListenerToBtn(ActionListener AL) {
        this.btn.addActionListener(AL);
    }

    /****************************************************************************/

    public CustomJPanel getCardPanel() {
        return this.cardPanel;
    }

    public AuthSizeConstants getSc() {
        return this.sc;
    }

    public CustomJPanel getPanel1() {
        return this.panel1;
    }

    public CustomJPanel getPanel2() {
        return this.panel2;
    }

    public CustomJPanel getPanel3() {
        return this.panel3;
    }

    public CardLayout getCardLayout() {
        return this.cardLayout;
    }

    public JButton getBtn() {
        return this.btn;
    }

    public JButton getRegisterButton() {
        return this.btnRegister;
    }

    public RegisterPageModel getRegisterPageModel()
    {
        return this.RPM;
    }

    public LoginPageModel getLoginPageModel() {
        return loginPageModel;
    }

    public Loop getMainLoop() {
        return mainLoop;
    }
}
