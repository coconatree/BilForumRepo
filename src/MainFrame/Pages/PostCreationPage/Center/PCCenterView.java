package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

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
        MigLayout layout = new MigLayout("inset 15 15 15 15", "[grow]", String.format("[%d]15[%d]15[grow]", model.getSc().getHEIGHT_RATIO() * 5, model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 5));
        this.setLayout(layout);

        this.initLowerPanel(model);

        this.initScrollPanel(model);

        model.getSp().setViewportView(model.getScrollPanel());

        this.add(model.getTitleField(), "grow, wrap");
        this.add(model.getSyntaxInfo(), "grow, wrap");
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
        MigLayout layout2 = new MigLayout("inset 5 5 5 5", String.format("[grow][%d]", model.getSc().getWIDTH_RATIO() * 35), "[grow]");
        model.getLowerPanel().setLayout(layout2);

        this.initTagsPanel(model);

        model.getLowerPanel().add(model.getSp(), "grow");
        model.getLowerPanel().add(model.getPanel1(), "grow");
    }

    private void initTagsPanel(PCCenterModel model)
    {
        MigLayout layout3 = new MigLayout("inset 5 5 5 5", "[grow]", String.format("[%d][grow][%d]", model.getSc().getHEIGHT_RATIO() * 5, model.getSc().getHEIGHT_RATIO() * 5));
        model.getPanel1().setLayout(layout3);

        model.getPanel1().add(model.getTagsTextField(), "grow, wrap");
        model.getPanel1().add(new JLabel(""), "grow, wrap");
        model.getPanel1().add(model.getPostBtn(), "grow");
    }
}
