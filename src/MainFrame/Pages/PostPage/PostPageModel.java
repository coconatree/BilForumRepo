package MainFrame.Pages.PostPage;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.MainFrameModel;
import MainFrame.Pages.ForumPage.LeftBar.LeftBarController;
import MainFrame.Pages.ForumPage.LeftBar.LeftBarModel;
import MainFrame.Pages.ForumPage.LeftBar.LeftBarView;
import MainFrame.Pages.PostPage.Center.POCenterController;
import MainFrame.Pages.PostPage.Center.POCenterModel;
import MainFrame.Pages.PostPage.Center.POCenterView;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class PostPageModel implements IPostPageModel{

    //Properties
    private IPostPageView postPageView ;
    private SizeConstants sizeConstants;

    private CustomJPanel panelRight;
    private JScrollPane scrollPane;

    //LeftBar
    private LeftBarModel LBM;
    private LeftBarView  LBV;
    private LeftBarController LBC;

    /*******************************************************************************************/

    private POCenterModel POCM;
    private POCenterView POCV;
    private POCenterController POCC;

    /*******************************************************************************************/

    //RightBar

    //Constructor
    public PostPageModel(MainFrameModel ref) {

        this.sizeConstants = new SizeConstants();
        this.scrollPane = new JScrollPane();

        this.scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        initPanels(ref);
    }

    //Methods
    private void initPanels(MainFrameModel ref) {
        this.LBM = new LeftBarModel(ref);
        this.LBV = new LeftBarView();
        this.LBC = new LeftBarController(this.LBV, this.LBM);

        this.LBM.setView(this.LBV);

        this.POCM = new POCenterModel();
        this.POCV = new POCenterView();
        this.POCC = new POCenterController(this.POCV, this.POCM, ref);

        this.POCM.setView(POCV);

        this.panelRight = new CustomJPanel();
        this.panelRight.setBackground( Color.red );
    }

    @Override
    public CustomJPanel getView() {
        this.postPageView.update(this);
        return (CustomJPanel) this.postPageView;
    }

    @Override
    public void setView(IPostPageView view) {
        this.postPageView = view;
    }

    @Override
    public void update() {
        this.postPageView.update(this);
    }

    public SizeConstants getSc()
    {
        return sizeConstants;
    }

    public JScrollPane getScrollPane()
    {
        return scrollPane;
    }

    public CustomJPanel getPanelR()
    {
        return this.panelRight;
    }

    public CustomJPanel getLeftBarView()
    {
        return this.LBM.getView();
    }

    public CustomJPanel getCenterView()
    {
        return this.POCM.getView();
    }

    public POCenterModel getPOCM() { return POCM; }
}
