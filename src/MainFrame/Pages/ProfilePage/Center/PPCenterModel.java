package MainFrame.Pages.ProfilePage.Center;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJPanel;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PPCenterModel implements IPPCenterModel{

    private SizeConstants sc;

    private IPPCenterView profilePageCenterView;

    private JTextField reputationPoint;

    private JTextPane userInformation;

    private JLabel profilePhoto;
    private JPanel sharedPanel;
    private JPanel followingPanel;
    private JButton editBtn;


    private String userInformationText = "username";
    /*******************************************************************************************/
    public  PPCenterModel()
    {
        this.sc = new SizeConstants();
        this.init();
    }
    private void init()
    {
        this.initFields();
        this.initButtons();
    }

    private void initFields()
    {
        this.profilePhoto = new JLabel("Photo");
        this.reputationPoint = new JTextField();//will get reputation point
        this.userInformation = new JTextPane();
        this.getUserInformation().setOpaque(true);
        this.getUserInformation().setEditable(false);
        this.getUserInformation().setText(this.getUserInformationText());

    }

    private void initButtons()
    {
        this.profilePhoto = new JLabel();
        this.profilePhoto.setText("PROFILE PHOTO");

        this.editBtn = new CustomJButton();
        this.editBtn.setText("EDIT PROFILE");
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

    public void addActionListenerToEditBtn(ActionListener next)
    {
        this.getEditBtn().addActionListener(next);
    }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    /*******************************************************************************************/

    public JTextField getReputationPoint() {
        return reputationPoint;
    }

    public JTextPane getUserInformation() {
        return userInformation;
    }

    public JButton getEditBtn() {
        return editBtn;
    }

    public String getUserInformationText() {
        return userInformationText;
    }

    public JLabel getProfilePhoto() {
        return profilePhoto;
    }
}


