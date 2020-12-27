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

    /*******************************************************************************************/

    private POCenterModel POCM;
    private POCenterView POCV;
    private POCenterController POCC;

    /*******************************************************************************************/

    //Constructor
    public PostPageModel(MainFrameModel ref) {

        this.sizeConstants = new SizeConstants();
        this.scrollPane = new JScrollPane();

        this.scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        this.scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.initPanels(ref);
    }

    //Methods
    private void initPanels(MainFrameModel ref) {

        this.POCM = new POCenterModel(ref);
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

    public CustomJPanel getCenterView()
    {
        return this.POCM.getView();
    }

    public POCenterModel getPOCM() { return POCM; }
}
