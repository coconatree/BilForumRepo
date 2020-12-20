package MainFrame.Pages.ForumPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.MainFrameModel;
import MainFrame.Pages.ForumPage.Center.CenterController;
import MainFrame.Pages.ForumPage.Center.CenterModel;
import MainFrame.Pages.ForumPage.Center.CenterView;
import MainFrame.Pages.ForumPage.LeftBar.LeftBarController;
import MainFrame.Pages.ForumPage.LeftBar.LeftBarModel;
import MainFrame.Pages.ForumPage.LeftBar.LeftBarView;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class ForumPageModel implements IForumPageModel
{
    private IForumPageView FPV;
    private SizeConstants sc;

    /*******************************************************************************************/

    private LeftBarModel LBM;
    private LeftBarView  LBV;
    private LeftBarController LBC;

    /*******************************************************************************************/

    private CenterModel CM;
    private CenterView  CV;
    private CenterController CC;

    /*******************************************************************************************/

    private CustomJPanel panelR;
    private JScrollPane scrollPane;

    /*******************************************************************************************/

    public ForumPageModel(MainFrameModel ref)
    {
        this.init(ref);
    }

    private void init(MainFrameModel ref)
    {
        this.sc = new SizeConstants();

        this.scrollPane = new JScrollPane();

        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.initPanels(ref);
    }

    private void initPanels(MainFrameModel ref)
    {
        this.LBM = new LeftBarModel(ref);
        this.LBV = new LeftBarView();
        this.LBC = new LeftBarController(this.LBV, this.LBM);

        this.LBM.setView(this.LBV);

        this.CM = new CenterModel();
        this.CV = new CenterView();
        this.CC = new CenterController(this.CV, this.CM, ref);

        this.CM.setView(this.CV);

        this.panelR = new CustomJPanel();
        this.panelR.setBackground(Color.YELLOW);
    }

    /*******************************************************************************************/

    @Override
    public void setView(IForumPageView view)
    {
        this.FPV = view;
    }

    @Override
    public void update()
    {
        this.FPV.update(this);
    }

    @Override
    public CustomJPanel getView()
    {
        this.FPV.update(this);
        return (CustomJPanel) this.FPV;
    }

    /*******************************************************************************************/

    public CenterModel getCM()
    {
        return this.CM;
    }

    public CenterController getCC(){ return this.CC; }

    /*******************************************************************************************/

    public CustomJPanel getLeftBarView()
    {
        return this.LBM.getView();
    }

    public JPanel getCenterView()
    {
        return this.CM.getView();
    }

    public CustomJPanel getPanelR()
    {
        return this.panelR;
    }

    public JScrollPane getScrollPane()
    {
        return scrollPane;
    }

    public SizeConstants getSc()
    {
        return sc;
    }
}