package MainFrame.Pages.MainMenu;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.MainFrameModel;
import MainFrame.Pages.MainMenu.ForumsPane.ForumsPaneController;
import MainFrame.Pages.MainMenu.ForumsPane.ForumsPaneModel;
import MainFrame.Pages.MainMenu.ForumsPane.ForumsPaneView;
import MainFrame.Pages.MainMenu.TopPosts.TopPostsController;
import MainFrame.Pages.MainMenu.TopPosts.TopPostsModel;
import MainFrame.Pages.MainMenu.TopPosts.TopPostsView;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class MainMenuModel implements IMainMenuModel {

    private IMainMenuView mainMenuView ;
    private SizeConstants sc ;

    /*******************************************************************************************/

    private TopPostsModel topPostsModel ;
    private TopPostsView topPostsView ;
    private TopPostsController topPostsController ;

    /*******************************************************************************************/

    private ForumsPaneModel forumsPaneModel ;
    private ForumsPaneView forumsPaneView ;
    private ForumsPaneController forumsPaneController ;

    /*******************************************************************************************/

    private CustomJPanel panelR;
    private JScrollPane scrollPane;

    /*******************************************************************************************/

    public MainMenuModel(MainFrameModel ref)
    {

        this.sc = new SizeConstants();

        this.scrollPane = new JScrollPane();

        this.scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        initPanels(ref);
    }

    private void initPanels( MainFrameModel ref){

        this.topPostsModel = new TopPostsModel();
        this.topPostsView = new TopPostsView();
        this.topPostsController = new TopPostsController();

        this.topPostsModel.setView( topPostsView );

        this.forumsPaneModel = new ForumsPaneModel();
        this.forumsPaneView = new ForumsPaneView();
        this.forumsPaneController = new ForumsPaneController();

        this.forumsPaneModel.setView( forumsPaneView );

        this.panelR = new CustomJPanel();
        this.panelR.setBackground( Color.cyan );
    }

    /*******************************************************************************************/

    // Get view forumPaneView donduruyordu

    @Override
    public CustomJPanel getView()
    {
        this.mainMenuView.update(this );
        return (CustomJPanel) this.mainMenuView;  // Emre
    }

    @Override
    public void setView(IMainMenuView view)
    {
        this.mainMenuView = view ;
    }

    @Override
    public void update()
    {
        this.mainMenuView.update(this);
    }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    public TopPostsModel getTopPostsModel() {
        return topPostsModel;
    }

    public ForumsPaneModel getForumsPaneModel() {
        return forumsPaneModel;
    }

    public CustomJPanel getPanelR() {
        return panelR;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    @Override
    public String toString()
    {
        return "Hello from the view";
    }
}
