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

    private JLabel logoLabel;   // Logo label
    private JLabel voteLabel;   // Vote Label
    private JLabel profLabel;   // Profile Label

    /*******************************************************************************************/

    private String sBtnText;

    private String rBtnText;
    private String bBtnText;
    private String nBtnText;

    private String logoLabelText;
    private String voteLabelText;
    private String profLabelText;

    /*******************************************************************************************/

    private Color background_color;

    /*******************************************************************************************/

    private JPanel logoPanel;

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

        this.initColors();

        this.initText();
        this.initPanels();
        this.initLabels();
        this.initButtons();
        this.initTextField();
    }

    /*******************************************************************************************/

    private void initColors()
    {
        this.background_color = Colors.NAVBAR_COLOR;
    }

    private void initText()
    {
        this.sBtnText = "Search";
        this.rBtnText = "Refresh";
        this.bBtnText = "Back";
        this.nBtnText = "Next";

        this.logoLabelText = "Bil-Forum";
        this.voteLabelText = "56";
        this.profLabelText = "Guest";
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
        this.logoLabel = new CustomJLabel();

        this.logoLabel = new JLabel("BİL-FORUM");
        this.logoLabel.setText(this.logoLabelText);
        this.logoLabel.setFont(Fonts.LOGO_FONT);
        this.logoLabel.setForeground(Colors.SECONDARY_COLOR);

        this.logoPanel.add(this.logoLabel, "grow");

        this.voteLabel = new JLabel();
        this.voteLabel.setText(this.voteLabelText);
        this.voteLabel.setFont(Fonts.TITLE_FONT);
        this.voteLabel.setForeground(Colors.SECONDARY_COLOR);

        this.profLabel = new JLabel();
        this.profLabel.setText(this.profLabelText);
        this.profLabel.setFont(Fonts.TITLE_FONT);
        this.profLabel.setForeground(Colors.SECONDARY_COLOR);
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

    public JLabel getLogoLabel()
    {
        return logoLabel;
    }

    public JLabel getVoteLabel()
    {
        return voteLabel;
    }

    public JLabel getProfLabel() {
        return profLabel;
    }

    /*******************************************************************************************/

    public Color getBackground_color()
    {
        return background_color;
    }

    public JPanel getLogoPanel()
    {
        return this.logoPanel;
    }
}