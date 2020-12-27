package MainFrame.Pages.MainMenu;

import MainFrame.CustomComponents.CustomForumComponent;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.MainFrameModel;
import MainFrame.Pages.MainMenu.ForumsPane.ForumsPaneController;
import MainFrame.Pages.MainMenu.ForumsPane.ForumsPaneModel;
import MainFrame.Pages.MainMenu.ForumsPane.ForumsPaneView;
import MainFrame.Pages.MainMenu.TopPosts.TopPostsController;
import MainFrame.Pages.MainMenu.TopPosts.TopPostsModel;
import MainFrame.Pages.MainMenu.TopPosts.TopPostsView;
import Static.Colors;
import Static.Fonts;
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

    private JLabel forumLabel;

    private JPanel forumPanel;

    public MainMenuModel(MainFrameModel ref)
    {

        this.sc = new SizeConstants();

        this.scrollPane = new JScrollPane();

        this.scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.forumLabel = new CustomJLabel();
        this.forumLabel.setText("Different Forums");
        this.forumLabel.setFont(Fonts.TITLE_FONT);

        this.forumPanel = new CustomJPanel();

        initPanels(ref);
    }

    private void initPanels( MainFrameModel ref){

        this.topPostsModel = new TopPostsModel(ref);
        this.topPostsView = new TopPostsView();
        this.topPostsController = new TopPostsController();

        this.topPostsModel.setView( topPostsView );

        this.forumsPaneModel = new ForumsPaneModel();
        this.forumsPaneView = new ForumsPaneView();
        this.forumsPaneController = new ForumsPaneController(this.forumsPaneView, this.forumsPaneModel, ref);

        this.forumsPaneModel.setView( forumsPaneView );

        this.panelR = new CustomJPanel();
    }

    /*******************************************************************************************/

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

    public JLabel getForumLabel() {
        return forumLabel;
    }

    public JPanel getForumPanel() {
        return forumPanel;
    }
}
