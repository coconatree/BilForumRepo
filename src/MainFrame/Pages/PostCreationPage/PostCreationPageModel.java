package MainFrame.Pages.PostCreationPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.MainFrameModel;
import MainFrame.Pages.PostCreationPage.Center.PCCenterController;
import MainFrame.Pages.PostCreationPage.Center.PCCenterModel;
import MainFrame.Pages.PostCreationPage.Center.PCCenterView;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class PostCreationPageModel implements IPostCreationPageModel
{
    private SizeConstants sc;

    private IPostCreationPageView postCreationPageView;

    /*******************************************************************************************/

    private JPanel panel1;

    /*******************************************************************************************/

    private PCCenterModel PCCenterModel;
    private PCCenterView   PCCenterView;
    private PCCenterController PCCenterController;

    /*******************************************************************************************/

    private JPanel panel3;

    /*******************************************************************************************/

    public PostCreationPageModel(MainFrameModel ref)
    {
        this.sc = new SizeConstants();

        this.initPCCenter(ref);

        this.initPanels();
    }

    private void initPCCenter(MainFrameModel ref)
    {
        this.PCCenterView  = new PCCenterView();
        this.PCCenterModel = new PCCenterModel(ref);
        this.PCCenterController = new PCCenterController(this.PCCenterView, this.PCCenterModel, ref);

        this.PCCenterModel.setView(this.PCCenterView);
    }


    private void initPanels()
    {
        this.panel1 = new CustomJPanel();
        this.panel1.setBackground(Color.BLUE);

        this.panel3= new CustomJPanel();
        this.panel3.setBackground(Color.BLUE);
    }

    /*******************************************************************************************/

    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel) this.postCreationPageView;
    }

    @Override
    public void setView(IPostCreationPageView view)
    {
        this.postCreationPageView = view;
    }

    @Override
    public void update()
    {
        this.postCreationPageView.update(this);
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return sc;
    }

    public PCCenterModel getPCCenterModel()
    {
        return PCCenterModel;
    }

    public JPanel getPanel1()
    {
        return panel1;
    }

    public JPanel getPanel3()
    {
        return panel3;
    }
}
