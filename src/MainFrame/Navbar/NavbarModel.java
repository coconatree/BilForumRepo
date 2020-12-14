package MainFrame.Navbar;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.CustomJTextField;
import MainFrame.MainFrameModel;
import Static.Colors;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        this.background_color = Colors.NAV_BAR_BACKGROUND;
    }

    private void initText()
    {
        this.sBtnText = "Search";
        this.rBtnText = "Refresh";
        this.bBtnText = "Back";
        this.nBtnText = "Next";

        this.logoLabelText = "Logo";
        this.voteLabelText = "56";
        this.profLabelText = "Profile";
    }

    private void initPanels()
    {
        this.lPanel = new JPanel();
        this.sPanel = new JPanel();
        this.pPanel = new JPanel();
    }

    private void initButtons()
    {
        this.sBtn = new CustomJButton();
        this.sBtn.setText(this.sBtnText);

        this.rBtn = new CustomJButton();
        this.rBtn.setText(this.rBtnText);

        this.bBtn = new CustomJButton();
        this.bBtn.setText(this.bBtnText);

        this.nBtn = new CustomJButton();
        this.nBtn.setText(this.nBtnText);
    }

    private void initLabels()
    {
        this.logoLabel = new JLabel();
        this.logoLabel.setText(this.logoLabelText);

        this.voteLabel = new JLabel();
        this.voteLabel.setText(this.voteLabelText);

        this.profLabel = new JLabel();
        this.profLabel.setText(this.profLabelText);
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

    public void addActionListenerToNextBtn(ActionListener AL)
    {
        this.nBtn.addActionListener(AL);
    }

    public void addActionListenerToBackBtn(ActionListener AL)
    {
        this.bBtn.addActionListener(AL);
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

    public CustomJButton getnBtn()
    {
        return nBtn;
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
}