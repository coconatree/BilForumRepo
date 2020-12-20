package AuthFrame;

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

    public AuthFrameModel( Loop mainLoop )
    {
        this.init( mainLoop );
    }

    private void init( Loop mainLoop )
    {
        this.sc = new AuthSizeConstants();

        this.panelLeft = new JPanel();

        MigLayout lefLayout = new MigLayout("", String.format("[%d]", this.sc.getWIDTH_RATIO() * 60), String.format("[%d]", this.sc.getHEIGHT()));
        this.panelLeft.setLayout(lefLayout);

        BufferedImage imgBuffer = null;

        try
        {
            URL url = AuthFrameModel.class.getResource("/AUTH_LOGO.png");

            imgBuffer = ImageIO.read(url);

            Image img = imgBuffer.getScaledInstance(this.sc.getWIDTH_RATIO() * 60, sc.getHEIGHT_RATIO() * 80, Image. SCALE_SMOOTH);

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

    public LoginPageModel getLoginPageModel() {
        return loginPageModel;
    }

    public Loop getMainLoop() {
        return mainLoop;
    }

    public JPanel getLeftPanel() { return this.panelLeft; }
}
