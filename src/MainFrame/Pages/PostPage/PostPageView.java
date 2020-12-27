package MainFrame.Pages.PostPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

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
        MigLayout layout = new MigLayout("inset 5 5 5 25","[grow]", "[grow]");
        this.setLayout(layout);

        PPM.getScrollPane().setViewportView(PPM.getCenterView());

        this.addAll(PPM);
    }

    private void addAll(PostPageModel PPM)
    {
        PPM.getScrollPane().setBorder(BorderFactory.createEmptyBorder());

        this.add(PPM.getScrollPane(), "grow");
    }
}
