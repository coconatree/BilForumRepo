package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class PCCenterView extends CustomJPanel implements IPCCenterView
{
    @Override
    public void update(PCCenterModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    private void init(PCCenterModel model)
    {
        MigLayout layout = new MigLayout("inset 15 15 15 15", "[grow]", String.format("[%d]5[%d]5[grow]5[%d]", model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 5));
        this.setLayout(layout);

        this.initLowerPanel(model);

        this.initScrollPanel(model);

        model.getSp().setViewportView(model.getScrollPanel());

        this.add(model.getTitleField(), "grow, wrap");
        this.add(model.getSyntaxInfo(), "grow, wrap");
        this.add(model.getSp(), "grow, wrap");
        this.add(model.getLowerPanel(), "grow, wrap");
    }

    private void initScrollPanel(PCCenterModel model)
    {
        MigLayout layout1 = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");

        model.getScrollPanel().setLayout(layout1);
        model.getScrollPanel().add(model.getContentInput(), "grow");
    }

    private void initLowerPanel(PCCenterModel model)
    {
        MigLayout layout2 = new MigLayout("inset 15 15 15 15", "[grow]", "[grow]");
        model.getLowerPanel().setLayout(layout2);

        model.getLowerPanel().add(model.getPostBtn(), "dock east");
    }
}
