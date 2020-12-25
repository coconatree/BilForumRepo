package MainFrame.Pages.ForumPage.Center.Post;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class PostView extends CustomJPanel implements IPostView
{
    @Override
    public void update(PostModel model)
    {
        this.init(model);
    }

    private void init(PostModel model)
    {
        this.addAll(model);
    }

    private void addAll(PostModel model)
    {
        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[grow]");

        this.setLayout(layout);

        this.add(model.getPostComponent(), "grow");
    }
}
