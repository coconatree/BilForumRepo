package MainFrame.Pages.ProfilePage;
import MainFrame.MainFrameModel;
import MainFrame.Navbar.NavbarModel;
import MainFrame.Pages.ProfilePage.Center.PPCenterModel;
import MainFrame.Pages.ProfilePage.Center.PPCenterView;
import MainFrame.Pages.ProfilePage.Center.PPCenterController;
import MainFrame.CustomComponents.CustomJPanel;
import PojoClasses.User;
import Static.SizeConstants;

import javax.swing.*;

public class ProfilePageModel implements IProfilePageModel{

    private SizeConstants sc;
    private IProfilePageView profilePageView;
    /*******************************************************************************************/
    private JPanel panel1;

    private PPCenterModel PPCenterModel;
    private PPCenterView PPCenterView;
    private PPCenterController PPCenterController;

    public ProfilePageModel(NavbarModel ref, MainFrameModel ref2)
    {
        this.sc = new SizeConstants();
        this.initPPCenter(ref, ref2);
    }
    private void initPPCenter(NavbarModel ref, MainFrameModel ref2)
    {
        this.PPCenterView = new PPCenterView();
        this.PPCenterModel = new PPCenterModel(ref);
        this.PPCenterController = new PPCenterController(this.PPCenterView, this.PPCenterModel, ref2);

        this.PPCenterModel.setView(this.PPCenterView);
    }
    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel) this.profilePageView;
    }

    @Override
    public void setView(IProfilePageView view) {
    this.profilePageView = view;
    }

    @Override
    public void update() {
    this.profilePageView.update(this);
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return sc;
    }

    public PPCenterModel getPPCenterModel()
    {
        return PPCenterModel;
    }


}
