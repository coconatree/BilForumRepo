package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ProfilePage.Center.PPCenterModel;
import Static.Colors;
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
        MigLayout layout = new MigLayout("inset 15 15 15 15", "[grow]", String.format("[%d]15[%d]15[grow][%d]", model.getSc().getHEIGHT_RATIO() * 5, model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 10));
        this.setLayout(layout);

        this.initTitlePanel(model);
        this.initGuidePanel(model);
        this.initMiddlePanel(model);
        this.initLowerPanel(model);

        this.add(model.getTitlePanel(), "grow, wrap");
        this.add(model.getGuidePanel(), "grow, wrap");
        this.add(model.getMiddlePanel(), "grow, wrap");
        this.add(model.getLowerPanel(), "grow, wrap");
    }

    private void initTitlePanel(PCCenterModel model)
    {
        MigLayout layout1 = new MigLayout("", "[grow]",String.format("[%d][grow]", model.getSc().getWIDTH_RATIO() * 5));
        model.getTitlePanel().setLayout(layout1);

        model.getTitlePanel().add(model.getTitleLabel(), "grow, wrap");
        model.getTitlePanel().add(model.getTitleField(), "grow");
    }

    private void initGuidePanel(PCCenterModel model)
    {
        MigLayout layoutGuide = new MigLayout("", "[grow]", "[grow]");
        model.getGuidePanel().setLayout(layoutGuide);

        model.getGuidePanel().add(model.getSyntaxInfo(), "grow");
    }

    private void initMiddlePanel(PCCenterModel model)
    {
        MigLayout layout2 = new MigLayout("", "[grow]", String.format("[%d][grow]", model.getSc().getWIDTH_RATIO() * 5));
        model.getMiddlePanel().setLayout(layout2);

        model.getSp().setViewportView(model.getScrollPanel());

        MigLayout layout1 = new MigLayout("inset 0 0 0 5", "[grow]", "[grow]");

        model.getScrollPanel().setLayout(layout1);
        model.getScrollPanel().add(model.getContentInput(), "grow");

        model.getMiddlePanel().add(model.getContentLabel(), "grow, wrap");
        model.getMiddlePanel().add(model.getSp(), "grow");
    }

    private void initLowerPanel(PCCenterModel model)
    {
        MigLayout layout3 = new MigLayout("", String.format("[grow][%d]", model.getSc().getWIDTH_RATIO() * 10), String.format("[%d][grow]15[%d]", model.getSc().getWIDTH_RATIO() * 5,  model.getSc().getWIDTH_RATIO() * 5));
        model.getLowerPanel().setLayout(layout3);

        model.getLowerPanel().add(model.getTagsLabel(), "grow, wrap");
        model.getLowerPanel().add(model.getTagsTextField(), "grow");
        model.getLowerPanel().add(model.getPostBtn(), "grow, wrap");
    }
}
