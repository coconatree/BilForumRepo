package MainFrame.Pages.ProfilePage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class PPCenterView extends CustomJPanel implements IPPCenterView {

    @Override
    public void update(PPCenterModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    private void init(PPCenterModel model)
    {
        MigLayout layout = new MigLayout("inset 15 15 15 15", "[grow]", String.format("[%d]5[%d]5[grow]5[%d]", model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 5));
        this.setLayout(layout);

        this.add(model.getProfilePhoto(), "grow");
        this.add(model.getReputationPoint(),"grow, wrap");
        this.add(model.getUserInformation(),"grow, wrap");
        this.add(model.getEditBtn(), "grow");
    }
}
