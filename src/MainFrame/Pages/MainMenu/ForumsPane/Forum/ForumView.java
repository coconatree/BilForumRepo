package MainFrame.Pages.MainMenu.ForumsPane.Forum;

import MainFrame.CustomComponents.CustomJPanel;
import Static.Colors;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * __ForumView class ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */

public class ForumView extends CustomJPanel implements IForumView
{
    @Override
    public void update(ForumModel model) {
        this.init(model);
    }

    private void init( ForumModel model)
    {
        MigLayout layout = new MigLayout( "" , "[grow]", "[grow]");
        this.setLayout( layout );

        this.add(model.getComp(), "grow, wrap");

        this.setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));
    }
}