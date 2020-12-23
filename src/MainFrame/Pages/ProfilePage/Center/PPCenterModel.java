package MainFrame.Pages.ProfilePage.Center;

import MainFrame.CustomComponents.CustomField;
import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.MainFrameModel;
import PojoClasses.User;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PPCenterModel implements IPPCenterModel{

    private SizeConstants sc;

    private IPPCenterView profilePageCenterView;

    private String userInformationText = "username";

    /*******************************************************************************************/

    private User currentUser;

    private CustomField field1;
    private CustomField field2;
    private CustomField field3;
    private CustomField field4;
    private CustomField field5;

    private JPanel panelL;
    private JPanel panelR;

    private JPanel panelT;
    private JPanel panelB;

    public  PPCenterModel()
    {
        this.sc = new SizeConstants();
        this.currentUser = null;
        this.init();
    }
    private void init()
    {
        this.panelL = new CustomJPanel();
        this.panelR = new CustomJPanel();

        this.panelT = new CustomJPanel();
        this.panelB = new CustomJPanel();

        this.field1 = new CustomField("Username: " , "Username");
        this.field2 = new CustomField("Email: " , "Username");
        this.field3 = new CustomField("Password: " , "Username");
        this.field4 = new CustomField("ID: " , "Username");
        this.field5 = new CustomField("Level: " , "Username");
    }

    public void initText()
    {
        this.field1 = new CustomField("Username: " , this.currentUser.getUsername());
        this.field2 = new CustomField("Email: " , this.currentUser.getEmail());
        this.field3 = new CustomField("Password: " , this.currentUser.getPasswordHashed());
        this.field4 = new CustomField("ID: " , this.currentUser.getUserID());
        this.field5 = new CustomField("Level: " , String.valueOf(this.currentUser.getUserLevel()));
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

    public CustomField getField3() {
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

    /****************************************************/

    public void setUser(User user)
    {
        this.currentUser = user;
        this.initText();
        this.update();
    }
}