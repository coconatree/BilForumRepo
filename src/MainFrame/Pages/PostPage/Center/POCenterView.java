package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class POCenterView extends CustomJPanel implements IPOCenterView {

    @Override
    public void update(POCenterModel model)
    {
        this.init(model);
    }

    private void init(POCenterModel model)
    {
        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[grow]5[grow]");

        this.setLayout(layout);

        this.add(new JLabel("HELLO"), "grow");
        this.add(model.getSyntaxModel().getView(), "grow");
    }
}
