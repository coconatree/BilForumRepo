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
        MigLayout layout0 = new MigLayout("", "[grow]", "[grow]");
        model.getPanelR().setLayout(layout0);
        model.getPanelR().add(model.getLogOut(), "center");

        MigLayout layout1 = new MigLayout("", "[grow]", "[70]15[70]15[70]15[70]");
        model.getPanelL().setLayout(layout1);

        model.getPanelL().add(model.getLabel(), "grow, wrap");
        model.getPanelL().add(model.getField1(), "grow, wrap");
        model.getPanelL().add(model.getField2(), "grow, wrap");
        model.getPanelL().add(model.getField3(), "grow, wrap");

        MigLayout layout3 = new MigLayout("", "[grow]5[grow]", "[grow]");
        model.getPanelT().setLayout(layout3);
        model.getPanelT().add(model.getPanelL(), "grow");
        model.getPanelT().add(model.getPanelR(), "grow");

        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[grow][grow]");
        this.setLayout(layout);

        this.add(model.getPanelT(), "grow, wrap");
        this.add(model.getPanelB(), "grow");
    }
}
