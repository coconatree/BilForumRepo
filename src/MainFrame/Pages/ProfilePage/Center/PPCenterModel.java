package MainFrame.Pages.ProfilePage.Center;

import MainFrame.CustomComponents.*;
import MainFrame.MainFrameModel;
import MainFrame.Navbar.NavbarModel;
import PojoClasses.User;
import Static.Colors;
import Static.Fonts;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PPCenterModel implements IPPCenterModel{

    private SizeConstants sc;

    private IPPCenterView profilePageCenterView;

    private String userInformationText = "username";

    /*******************************************************************************************/

    private User currentUser;

    private CustomField field1;
    private CustomField field2;
    private CustomFieldP field3;
    private CustomField field4;
    private CustomField field5;

    private JPanel panelL;
    private JPanel panelR;

    private JPanel panelT;
    private JPanel panelB;

    private JLabel label;
    private JButton logOut;

    private NavbarModel ref;

    public  PPCenterModel(NavbarModel ref)
    {
        this.sc = new SizeConstants();
        this.currentUser = null;
        this.ref = ref;
        this.init();
    }
    private void init()
    {
        this.logOut = new CustomJButton();
        this.logOut.setText("Log Out");

        this.label = new CustomJLabel();
        this.label.setText("Change your account details:");
        this.label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        this.label.setForeground(Colors.SECONDARY_COLOR);

        this.panelL = new CustomJPanel();
        this.panelR = new CustomJPanel();

        this.panelT = new CustomJPanel();
        this.panelB = new CustomJPanel();

        this.field1 = new CustomField("Username: " , "Username", "USERNAME", this, this.ref);
        this.field2 = new CustomField("Email: " , "Username", "EMAIL", this, this.ref);
        this.field3 = new CustomFieldP("Password: " , "Username", "PASSWORD", this, this.ref);

    }

    public void initText()
    {
        this.field1 = new CustomField("Username: " , this.currentUser.getUsername(), "USERNAME", this, this.ref);
        this.field2 = new CustomField("Email: " , this.currentUser.getEmail(), "EMAIL", this, this.ref);
        this.field3 = new CustomFieldP("Password: " , "**********", "PASSWORD", this, this.ref);
    }


    /*********************************************************************************************/

    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel) this.profilePageCenterView;
    }

    @Override
    public void setView(PPCenterView view)
    {
        this.profilePageCenterView = view;
    }

    @Override
    public void update()
    {
        this.profilePageCenterView.update(this);
    }

    /*******************************************************************************************/

    public void addActionListenerToLogOut(ActionListener AL){ this.logOut.addActionListener(AL); }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    /*******************************************************************************************/

    public CustomField getField1() {
        return field1;
    }

    public CustomField getField2() {
        return field2;
    }

    public CustomFieldP getField3()
    {
        return field3;
    }

    public CustomField getField4() {
        return field4;
    }

    public CustomField getField5() {
        return field5;
    }

    public JPanel getPanelL() {
        return panelL;
    }

    public JPanel getPanelR() {
        return panelR;
    }

    public JPanel getPanelT() {
        return panelT;
    }

    public JPanel getPanelB() {
        return panelB;
    }

    public JLabel getLabel(){ return this.label; }

    public JButton getLogOut(){ return this.logOut; }

    /****************************************************/

    public void setUser(User user)
    {
        this.currentUser = user;
        this.initText();
        this.update();
    }

    public User getUser()
    {
        return this.currentUser;
    }
}