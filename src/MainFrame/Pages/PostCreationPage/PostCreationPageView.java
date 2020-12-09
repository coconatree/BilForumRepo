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
        MigLayout layout = new MigLayout("inset 15 15 15 15", String.format("[%d]15[grow]15[%d]", model.getSc().getWIDTH_RATIO() * 15, model.getSc().getWIDTH_RATIO() * 15), "[grow]");

        this.setLayout(layout);

        this.add(model.getPanel1(), "grow");
        this.add(model.getPCCenterModel().getView(), "grow");
        this.add(model.getPanel3(), "grow");
    }
}
