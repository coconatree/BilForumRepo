package MainFrame.Pages.MainMenu.ForumsPane.Forum;

import MainFrame.CustomComponents.CustomForumComponent;
import MainFrame.CustomComponents.CustomJPanel;
import Static.SizeConstants;
import PojoClasses.Forum;
import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * __ForumModel class ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */

public class ForumModel implements IForumModel{

    private IForumView forumView;
    private SizeConstants sc ;

    /*******************************************************************************************/

    private CustomForumComponent comp;

    /*******************************************************************************************/

    public ForumModel( Forum forumObj)
    {
        this.init(forumObj);
    }

    private void init(Forum forumObj)
    {
        this.sc = new SizeConstants();
        this.comp = new CustomForumComponent(forumObj);
    }

    public void addMouseListenerToComp(MouseListener ML)
    {
        this.comp.addMouseListener(ML);
    }

    /*******************************************************************************************/

    @Override
    public void update() {
        this.forumView.update(this);
    }

    @Override
    public void setView(IForumView view) {
        this.forumView = view ;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel)this.forumView;
    }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    public CustomForumComponent getComp()
    {
        return comp;
    }
}
