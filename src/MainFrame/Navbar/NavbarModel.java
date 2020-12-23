package MainFrame.Navbar;

import AuthFrame.AuthFrameModel;
import MainFrame.CustomComponents.*;
import MainFrame.MainFrameModel;
import Static.Colors;
import Static.Fonts;
import Static.SizeConstants;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class NavbarModel implements INavbarModel
{
    private SizeConstants sc;
    
    private INavbarView navbarView;

    /*******************************************************************************************/

    private JPanel lPanel;  // Logo Panel
    private JPanel sPanel;  // Search Panel
    private JPanel pPanel;  // Profile Panel

    /*******************************************************************************************/

    private CustomJTextField sTF; // Search text field

    /*******************************************************************************************/

    private CustomJButton sBtn;   // Search Button
    private CustomJButton rBtn;   // Refresh Button
    private CustomJButton bBtn;   // Back Button
    private CustomJButton nBtn;   // Forward Button

    /*******************************************************************************************/

    private CustomDoubleJLabel pointsLabel;   // Logo CustomDoubleJLabel

    private CustomImagePanel profPicture;   // Profile picture

    private JLabel profLabel;

    private CustomImagePanel logoLabel;

    /*******************************************************************************************/

    private String sBtnText;

    private String rBtnText;
    private String bBtnText;

    private String logoLabelText;

    /*******************************************************************************************/

    private JPanel logoPanel;
    private JPanel profPanel;

    /*******************************************************************************************/

    MainFrameModel ref;

    public NavbarModel(MainFrameModel mainFrameModelRef)
    {
        this.init(mainFrameModelRef);
    }

    private void init(MainFrameModel mainFrameModelRef)
    {
        this.sc = new SizeConstants();
        this.ref = mainFrameModelRef;

        this.initText();
        this.initPanels();
        this.initLabels();
        this.initButtons();
        this.initTextField();
    }

    /*******************************************************************************************/

    private void initText()
    {
        this.sBtnText = "Search";
        this.rBtnText = "Refresh";
        this.bBtnText = "Back";

        this.logoLabelText = "Bil-Forum";
    }

    private void initPanels()
    {
        this.lPanel = new JPanel();
        this.lPanel.setOpaque(false);

        this.sPanel = new JPanel();
        this.sPanel.setOpaque(false);

        this.pPanel = new JPanel();
        this.pPanel.setOpaque(false);
    }

    private void initButtons()
    {
        this.sBtn = new CustomJButton();
        this.sBtn.setText(this.sBtnText);

        this.rBtn = new CustomJButton();
        this.rBtn.setText(this.rBtnText);

        this.bBtn = new CustomJButton();
        this.bBtn.setText(this.bBtnText);
    }

    private void initLabels()
    {
        this.logoPanel = new JPanel();

        MigLayout logoLayout = new MigLayout("", String.format("[%d]", this.sc.getWIDTH_RATIO() * 60), String.format("[%d]", this.sc.getHEIGHT()));

        this.logoPanel.setLayout(logoLayout);
        this.logoLabel = new CustomImagePanel("LOGO", "/AUTH_LOGO.png", new Dimension(sc.getWIDTH_RATIO() * 10, sc.getHEIGHT_RATIO() * 10));

        this.logoPanel.add(this.logoLabel, "grow");

        this.pointsLabel = new CustomDoubleJLabel("20", "Points");

        this.profPicture = new CustomImagePanel("PROFİLE", "/PROFILE_LOGO.png", new Dimension(sc.getWIDTH_RATIO() * 5, sc.getHEIGHT_RATIO() * 5));
        this.profLabel = new CustomJLabel();
        this.profLabel.setText("Guest");
        this.profLabel.setFont(Fonts.TITLE_FONT);
        this.profLabel.setForeground(Colors.SECONDARY_COLOR);

        this.profPanel = new CustomJPanel();
    }

    private void initTextField()
    {
        this.sTF = new CustomJTextField(5);
    }

    /*******************************************************************************************/

    @Override
    public CustomJPanel getView()
    {
        this.navbarView.update(this);
        return (CustomJPanel) this.navbarView;
    }

    @Override
    public void setView(INavbarView view)
    {
        this.navbarView = view;
    }

    @Override
    public void update()
    {
        this.navbarView.update(this);
    }

    /*******************************************************************************************/

    public void addActionListenerToBackBtn(ActionListener AL)
    {
        this.bBtn.addActionListener(AL);
    }

    public void addActionListenerToRefreshBtn(ActionListener Al)
    {
        this.rBtn.addActionListener(Al);
    }

    public void addMouseListenerToLogoLabel(MouseListener Ml)
    {
        this.logoLabel.addMouseListener(Ml);
    }

    public void addMouseListenerToProfile(MouseListener ML)
    {
        this.profPanel.addMouseListener(ML);
    }

    /*******************************************************************************************/

    public MainFrameModel getRef()
    {
        return ref;
    }

    public SizeConstants getSc()
    {
        return sc;
    }

    public JPanel getlPanel()
    {
        return lPanel;
    }

    public JPanel getsPanel()
    {
        return sPanel;
    }

    public JPanel getpPanel()
    {
        return pPanel;
    }

    public JTextField getsTF()
    {
        return sTF;
    }

    public CustomJButton getsBtn()
    {
        return sBtn;
    }

    public CustomJButton getrBtn()
    {
        return rBtn;
    }

    public CustomJButton getbBtn()
    {
        return bBtn;
    }

    public CustomImagePanel getLogoLabel()
    {
        return logoLabel;
    }

    public CustomDoubleJLabel getVoteLabel()
    {
        return this.pointsLabel;
    }

    public JLabel getProfLabel() {
        return profLabel;
    }

    public CustomImagePanel getProfPicture() {
        return profPicture;
    }

    public JPanel getProfPanel() {
        return profPanel;
    }

    /*******************************************************************************************/

    public JPanel getLogoPanel()
    {
        return this.logoPanel;
    }
}