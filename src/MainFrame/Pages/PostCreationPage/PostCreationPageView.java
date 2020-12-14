package MainFrame.Pages.PostCreationPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class PostCreationPageView extends CustomJPanel implements IPostCreationPageView
{
    @Override
    public void update(PostCreationPageModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    private void init(PostCreationPageModel model)
    {
        MigLayout layout = new MigLayout("inset 15 15 15 15", "[grow]", "[grow]");

        this.setLayout(layout);
        this.add(model.getPCCenterModel().getView(), "grow");
    }
}
