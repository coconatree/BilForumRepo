package MainFrame.Pages.ForumPage.LeftBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftBarController
{
    private LeftBarView LBV;
    private LeftBarModel LBM;

    public LeftBarController(LeftBarView LBV, LeftBarModel LBM)
    {
        this.LBV = LBV;
        this.LBM = LBM;

        this.LBM.addActionListenerToAddPostBtn(new PostPageNavigationListener());
    }

    class PostPageNavigationListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    LBM.getRef().getCardLayout().show(LBM.getRef().getCardPanel(), "POST_CREATION_PAGE");
                }
            });
        }
    }
}
