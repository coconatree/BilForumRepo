package MainFrame.Pages.MainMenu.ForumsPane.Forum;

import MainFrame.CustomComponents.CustomJPanel;
/**
 * __The interface for ForumModels ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */
public interface IForumModel {

    void update();

    void setView( IForumView view);

    CustomJPanel getView();

}
