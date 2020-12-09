package MainFrame.Pages.ProfilePage;
import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class ProfilePageView extends CustomJPanel implements IProfilePageView
{

    @Override
    public void update(ProfilePageModel model) {
     this.init(model);
     this.validate();
     this.repaint();
    }
    public void init(ProfilePageModel model)
    {
        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");

        this.setLayout(layout);
        this.add(model.getPPCenterModel().getView(), "grow");
    }
}
