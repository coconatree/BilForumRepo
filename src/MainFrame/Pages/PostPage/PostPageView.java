package MainFrame.Pages.PostPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class PostPageView extends CustomJPanel implements IPostPageView {

    @Override
    public void update(PostPageModel PPM)
    {
        this.init(PPM);
        this.validate();
        this.repaint();
    }

    private void init(PostPageModel PPM)
    {
        MigLayout layout = new MigLayout("inset 5 5 5 5", String.format("[%d]15[grow]15[%d]", PPM.getSc().getWIDTH_RATIO() * 15, PPM.getSc().getWIDTH_RATIO() * 15), "[grow]");
        this.setLayout(layout);

        PPM.getScrollPane().setViewportView(PPM.getCenterView());

        this.addAll(PPM);
    }

    private void addAll(PostPageModel PPM)
    {
        this.add(PPM.getLeftBarView(), "grow");
        this.add(PPM.getScrollPane(), "grow");
        this.add(PPM.getPanelR(), "grow");
    }
}
