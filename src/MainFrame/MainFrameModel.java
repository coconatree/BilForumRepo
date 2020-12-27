package MainFrame;

import MainFrame.CustomComponents.CustomJFrame;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Navbar.INavbarView;
import MainFrame.Navbar.NavbarController;
import MainFrame.Navbar.NavbarModel;
import MainFrame.Navbar.NavbarView;
import MainFrame.Pages.ForumPage.ForumPageController;
import MainFrame.Pages.ForumPage.ForumPageModel;
import MainFrame.Pages.ForumPage.ForumPageView;
import MainFrame.Pages.ForumPage.IForumPageView;
import MainFrame.Pages.MainMenu.MainMenuController;
import MainFrame.Pages.MainMenu.MainMenuModel;
import MainFrame.Pages.MainMenu.MainMenuView;
import MainFrame.Pages.PostCreationPage.PostCreationPageController;
import MainFrame.Pages.PostCreationPage.PostCreationPageModel;
import MainFrame.Pages.PostCreationPage.PostCreationPageView;
import MainFrame.Pages.ProfilePage.ProfilePageController;
import MainFrame.Pages.ProfilePage.ProfilePageModel;
import MainFrame.Pages.ProfilePage.ProfilePageView;
import MainFrame.Pages.PostPage.PostPageController;
import MainFrame.Pages.PostPage.PostPageModel;
import MainFrame.Pages.PostPage.PostPageView;
import PojoClasses.Post;
import PojoClasses.User;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrameModel implements IMainFrameModel
{
    private SizeConstants sc;

    private IMainFrameView MFV;

    /*******************************************************************************************/

    private User currentUser;

    private ArrayList<String> pagesList;

    /*******************************************************************************************/

    private NavbarModel NBM;
    private INavbarView NBV;
    private NavbarController NBC;

    /*******************************************************************************************/

    private ForumPageModel FPM;
    private IForumPageView FPV;
    private ForumPageController FPC;

    /*******************************************************************************************/

    private PostCreationPageModel PostCreationPageModel;
    private PostCreationPageView PostCreationPageView;
    private PostCreationPageController PostCreationController;

    /*******************************************************************************************/

    private ProfilePageModel ProfilePageModel;
    private ProfilePageView ProfilePageView;
    private ProfilePageController ProfilePageController;

    /*******************************************************************************************/

    private MainMenuView MMV;
    private MainMenuModel MMM;
    private MainMenuController MMC;

    /*******************************************************************************************/
    
    private PostPageView PPV;
    private PostPageModel PPM;
    private PostPageController PPC;
    
    /*******************************************************************************************/

    private CustomJPanel cardPanel;

    private CardLayout cardLayout;

    /*******************************************************************************************/

    private CustomJPanel panel;
    private JLabel labelTemp;

    public MainFrameModel()
    {
        this.init();
    }

    public void setUser(User user)
    {
        this.currentUser = user;
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.pagesList = new ArrayList<>();
        this.pagesList.add("MAIN_MENU");

        this.createNavbar();

        this.createForumPage();
        this.createPostCreationPage();
        this.createProfilePage();
        this.createMainMenu();

        this.cardPanel = new CustomJPanel();

        /******************/

        this.panel = new CustomJPanel();
        this.labelTemp= new JLabel();
        this.labelTemp.setText("DENEME");

    }

    private void createMainMenu()
    {
        this.MMV = new MainMenuView();
        this.MMM = new MainMenuModel(this);
        this.MMC = new MainMenuController(this.MMM, this.MMV);

        this.MMM.setView(this.MMV);
    }

    private void createNavbar()
    {
        this.NBV = new NavbarView();
        this.NBM = new NavbarModel(this);
        this.NBC = new NavbarController(this.NBV, this.NBM, this);

        this.NBM.setView(this.NBV);
    }

    private void createForumPage()
    {
        this.FPV = new ForumPageView();
        this.FPM = new ForumPageModel(this);
        this.FPC = new ForumPageController(this.FPV, this.FPM);

        this.FPM.setView(this.FPV);
    }

    private void createPostCreationPage()
    {
        this.PostCreationPageView   = new PostCreationPageView();
        this.PostCreationPageModel  = new PostCreationPageModel(this);
        this.PostCreationController = new PostCreationPageController(this.PostCreationPageView, this.PostCreationPageModel);

        this.PostCreationPageModel.setView(this.PostCreationPageView);
    }

    private void createProfilePage()
    {
        this.ProfilePageView = new ProfilePageView();
        this.ProfilePageModel  = new ProfilePageModel(this.NBM, this);
        this.ProfilePageController = new ProfilePageController();

        this.ProfilePageModel.setView(this.ProfilePageView);
    }

    /*******************************************************************************************/
    
    private void createPostPage(String data)
    {
        this.PPV = new PostPageView();
        this.PPM = new PostPageModel(this, data);
        this.PPC = new PostPageController(this.PPV, this.PPM);

        this.PPM.setView(this.PPV);
    }

    /*******************************************************************************************/

    public void changePage(String pageName, Boolean back)
    {
        this.cardLayout.show(this.cardPanel, pageName);
    }

    public void changePage(String pageName)
    {
        this.cardLayout.show(this.cardPanel, pageName);
        this.pagesList.add(pageName);
    }

    public void changePage(String pageName, String data, Post post)
    {
        this.createPostPage(data);

        this.getPostPageModel().getPOCM().resetComments();
        this.getPostPageModel().getPOCM().resetAnswers();

        this.getPostPageModel().getPOCM().setPost(post);
        this.getPostPageModel().getPOCM().setPostDetailsContents();

        this.getPostPageModel().getPOCM().update();

        this.getCardPanel().add(this.getPostPageModel().getView(), "POST_PAGE");

        this.cardLayout.show(this.cardPanel, pageName);
        this.pagesList.add(pageName);
    }

    /*******************************************************************************************/

    @Override
    public void update()
    {
        this.MFV.update(this);
    }

    @Override
    public void setView(IMainFrameView MFV)
    {
        this.MFV = MFV;
    }


    @Override
    public CustomJFrame getView()
    {
        this.update();
        return (CustomJFrame) this.MFV;
    }

    /*******************************************************************************************/

    public CustomJPanel getNavbarView()
    {
        this.NBM.update();
        return (CustomJPanel) this.NBV;
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return this.sc;
    }

    /*******************************************************************************************/

    public ProfilePageModel getProfilePageModel()
    {
        return this.ProfilePageModel;
    }

    public PostCreationPageModel getPostCreationPageModel()
    {
        return this.PostCreationPageModel;
    }

    public ForumPageModel getFPM()
    {
        return this.FPM;
    }
    
    public PostPageModel getPostPageModel()
    {
        return this.PPM;
    }

    public NavbarModel getNVM()
    {
        return this.NBM;
    }

    /*******************************************************************************************/

    public CustomJPanel getCardPanel()
    {
        return this.cardPanel;
    }

    public CardLayout getCardLayout()
    {
        return this.cardLayout;
    }

    public void setCardLayout(CardLayout layout)
    {
        this.cardLayout = layout;
    }

    /*********************************************************************************************/

    public CustomJPanel getPanel()
    {
        return panel;
    }

    public JLabel getLabelTemp()
    {
        return labelTemp;
    }

    public MainMenuModel getMMM()
    {
        return MMM;
    }

    public User getCurrentUser()
    {
        return this.currentUser;
    }

    public ArrayList<String> getPageList()
    {
        return this.pagesList;
    }
}
