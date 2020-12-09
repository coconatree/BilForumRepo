package MainFrame.Pages.ForumPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class ForumPageView extends CustomJPanel implements IForumPageView
{
    @Override
    public void update(ForumPageModel FPM)
    {
        this.init(FPM);
        this.validate();
        this.repaint();
    }

    private void init(ForumPageModel FPM)
    {
        MigLayout layout = new MigLayout("inset 5 5 5 5", String.format("[%d]15[grow]15[%d]", FPM.getSc().getWIDTH_RATIO() * 15, FPM.getSc().getWIDTH_RATIO() * 15), "[grow]");
        this.setLayout(layout);

        FPM.getScrollPane().setViewportView(FPM.getCenterView());

        this.addAll(FPM);
    }

    private void addAll(ForumPageModel FPM)
    {
        this.add(FPM.getLeftBarView(), "grow");
        this.add(FPM.getScrollPane(), "grow");
        this.add(FPM.getPanelR(), "grow");
    }
}