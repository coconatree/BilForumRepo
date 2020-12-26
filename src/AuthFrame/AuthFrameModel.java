package AuthFrame;

import AuthFrame.EmailPage.EmailPageController;
import AuthFrame.EmailPage.EmailPageModel;
import AuthFrame.EmailPage.EmailPageView;
import AuthFrame.ForgetPasswordPage.ForgetPasswordPageController;
import AuthFrame.ForgetPasswordPage.ForgetPasswordPageModel;
import AuthFrame.ForgetPasswordPage.ForgetPasswordPageView;
import AuthFrame.RegisterPage.RegisterPageController;
import AuthFrame.RegisterPage.RegisterPageModel;
import AuthFrame.RegisterPage.RegisterPageView;
import AuthFrame.LoginPage.LoginPageController;
import AuthFrame.LoginPage.LoginPageModel;
import AuthFrame.LoginPage.LoginPageView;
import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJFrame;
import MainFrame.CustomComponents.CustomJPanel;
import MainLoop.Loop;
import Static.AuthSizeConstants;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AuthFrameModel implements IAuthFrameModel {
    private AuthSizeConstants sc;
    private IAuthFrameView authFrameView;
    private Loop mainLoop ;

    /****************************************************************************/

    private JPanel panelLeft;

    private JLabel imageLabel;

    private CustomJPanel cardPanel;

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
    private EmailPageView EPV;
    private EmailPageModel EPM;
    private EmailPageController EPC;

    /****************************************************************************/

    private ForgetPasswordPageView FPV;
    private ForgetPasswordPageModel FPM;
    private ForgetPasswordPageController FPC;

    /****************************************************************************/

    public AuthFrameModel( Loop mainLoop )
    {
        this.init( mainLoop );
    }

    private void init( Loop mainLoop )
    {
        this.sc = new AuthSizeConstants();

        this.panelLeft = new JPanel();

        MigLayout lefLayout = new MigLayout("", String.format("[%d]", this.sc.getWIDTH_RATIO() * 72), String.format("[%d]", this.sc.getHEIGHT()));
        this.panelLeft.setLayout(lefLayout);

        BufferedImage imgBuffer = null;

        try
        {
            URL url = AuthFrameModel.class.getResource("/AUTH_LOGO.png");

            imgBuffer = ImageIO.read(url);

            Image img = imgBuffer.getScaledInstance(this.sc.getWIDTH_RATIO() * 47, sc.getHEIGHT_RATIO() * 80, Image. SCALE_SMOOTH);

            this.imageLabel =  new JLabel(new ImageIcon(img));
        }
        catch (IOException e)
        {
            this.imageLabel = new JLabel("ERROR");
            e.printStackTrace();
        }

        this.panelLeft.setOpaque(false);

        this.panelLeft.add(this.imageLabel, "dock north");

        this.cardPanel = new CustomJPanel();

        this.mainLoop = mainLoop ;

        this.panel3 = new CustomJPanel();
        this.panel3.setBackground(Color.BLUE);

        this.cardLayout = new CardLayout();

        this.createLoginPage();
        this.createRegisterPage();
        this.createEmailPage();
        this.createPasswordPage();
    }

    public void changePage(String pageName)
    {
        this.cardLayout.show(this.cardPanel, pageName);
    }

    private void createLoginPage()
    {
        this.loginPageView = new LoginPageView();
        this.loginPageModel = new LoginPageModel( this );
        this.loginPageController = new LoginPageController( loginPageModel , loginPageView, this);

        this.loginPageModel.setView( this.loginPageView );
    }


    private void createRegisterPage()
    {
        this.RPV = new RegisterPageView();
        this.RPM = new RegisterPageModel();
        this.RPC = new RegisterPageController(this.RPV, this.RPM, this);

        this.RPM.setView(this.RPV);
    }

    /****************************************************************************/
    private void createEmailPage()
    {
        this.EPV = new EmailPageView();
        this.EPM = new EmailPageModel();
        this.EPC = new EmailPageController(this.EPM, this.EPV, this);

        this.EPM.setView(this.EPV);
    }
    private void createPasswordPage()
    {
        this.FPV = new ForgetPasswordPageView();
        this.FPM = new ForgetPasswordPageModel();
        this.FPC = new ForgetPasswordPageController(this.FPV, this.FPM, this);

        this.FPM.setView(this.FPV);
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

    /****************************************************************************/

    public CustomJPanel getCardPanel() {
        return this.cardPanel;
    }

    public AuthSizeConstants getSc() {
        return this.sc;
    }

    public CustomJPanel getPanel3() {
        return this.panel3;
    }

    public CardLayout getCardLayout() {
        return this.cardLayout;
    }

    public RegisterPageModel getRegisterPageModel()
    {
        return this.RPM;
    }

    public ForgetPasswordPageModel getForgetPasswordPageModel()
    {
        return this.FPM;
    }

    public LoginPageModel getLoginPageModel() {
        return loginPageModel;
    }
    
    public EmailPageModel getEmailPageModel() {
        return EPM;
    }

    public Loop getMainLoop() {
        return mainLoop;
    }

    public JPanel getLeftPanel() { return this.panelLeft; }
}
