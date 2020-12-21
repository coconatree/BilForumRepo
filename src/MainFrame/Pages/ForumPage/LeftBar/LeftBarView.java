package MainFrame.Pages.ForumPage.LeftBar;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class LeftBarView extends CustomJPanel implements ILeftBarView
{
    @Override
    public void update(LeftBarModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    private void init(LeftBarModel model)
    {
        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow][grow]", String.format("[grow][%d]", model.getSc().getHEIGHT_RATIO() * 15));

        this.setLayout(layout);
        this.addAll(model);
    }

    private void addAll(LeftBarModel model)
    {
        MigLayout topPanelLayout = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");

        model.getTopPanel().setLayout(topPanelLayout);
        model.getTopPanel().add(model.getTextPane(), "grow");

        MigLayout bottomPanelLayout = new MigLayout("inset 5 5 5 5", "[grow]5[grow]", "[grow]5[grow]");

        model.getBottomPanel().setLayout(bottomPanelLayout);
        model.getBottomPanel().add(model.getByViewButton(), "growx");
        model.getBottomPanel().add(model.getByVoteButton(), "growx, wrap");
        model.getBottomPanel().add(model.getAddPostButton(), "growx, span 2");

        this.add(model.getTopPanel(), "grow, span");
        this.add(model.getBottomPanel(), "grow");
    }
}
