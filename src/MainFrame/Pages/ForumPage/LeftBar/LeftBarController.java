package MainFrame.Pages.ForumPage.LeftBar;

import MainFrame.MainFrameModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftBarController
{
    private LeftBarView LBV;
    private LeftBarModel LBM;

    private MainFrameModel ref;

    public LeftBarController(LeftBarView LBV, LeftBarModel LBM, MainFrameModel ref)
    {
        this.LBV = LBV;
        this.LBM = LBM;

        this.ref = ref;

        this.LBM.addActionListenerToAddPostBtn(new PostPageNavigationListener());
        this.LBM.addActionListenerToByDateBtn(new PostPageSortByViewListener());
        this.LBM.addActionListenerToByVoteBtn(new PostPageSortByVoteListener());
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
                    LBM.getRef().changePage("POST_CREATION_PAGE");
                }
            });
        }
    }
    class PostPageSortByVoteListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    LBM.getRef().getFPM().getCM().wakeVote();
                    ref.getFPM().getCC().updateMouseListener();
                }
            });
        }
    }
    class PostPageSortByViewListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    LBM.getRef().getFPM().getCM().wakeView();
                    ref.getFPM().getCC().updateMouseListener();
                }
            });
        }
    }
}
