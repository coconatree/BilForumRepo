package MainFrame.Pages.ForumPage.Center;

import MainFrame.CustomComponents.PostComponent;
import MainFrame.MainFrameModel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CenterController
{
    private CenterView CV;
    private CenterModel CM;

    private MainFrameModel ref;

    public CenterController(CenterView view, CenterModel model, MainFrameModel ref)
    {
        this.CV = view;
        this.CM = model;

        this.ref = ref;

        this.updateMouseListener();
    }

    public void updateMouseListener()
    {
        this.CM.addMouseListener(new PostMouseListener());
    }

    class PostMouseListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    PostComponent cmp = (PostComponent) e.getSource();

                    ref.getPostPageModel().getPOCM().setPost(cmp.getPost());
                    ref.getPostPageModel().getPOCM().setContent();
                    ref.getPostPageModel().getPOCM().update();
                    ref.changePage("POST_PAGE");
                }
            });
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

