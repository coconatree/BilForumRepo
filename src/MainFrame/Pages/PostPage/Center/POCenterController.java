package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.PostComponent;
import MainFrame.MainFrameModel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class POCenterController {

    private POCenterView POCV;
    private POCenterModel POCM;

    private MainFrameModel ref;

    public POCenterController(POCenterView view, POCenterModel model, MainFrameModel ref)
    {
        this.POCV = view;
        this.POCM = model;

        this.ref = ref;

        this.updateMouseListener();
    }

    public void updateMouseListener()
    {
        this.POCM.addMouseListener(new POCenterController.PostMouseListener());
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
                    // ref.getLabelTemp().setText(Integer.toString(cmp.getView()));
                    //ref.getLabelTemp().setText(cmp.getTitle());

                    ref.getCardLayout().show(ref.getCardPanel(), "PANEL_TEMP");
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
