package MainFrame.Pages.MainMenu.ForumsPane;

import MainFrame.CustomComponents.CustomForumComponent;
import MainFrame.MainFrameModel;
import MainFrame.Pages.MainMenu.ForumsPane.Forum.ForumModel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ForumsPaneController
{
    private ForumsPaneView view;
    private ForumsPaneModel model;

    MainFrameModel ref;

    public ForumsPaneController(ForumsPaneView view, ForumsPaneModel model, MainFrameModel ref)
    {
        this.view = view;
        this.model = model;
        this.ref = ref;

        for (ForumModel fModel : this.model.getForumList())
        {
            fModel.getComp().addMouseListener(new MainMenuNavListener());
        }
    }

    class MainMenuNavListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            CustomForumComponent comp = (CustomForumComponent) e.getSource();

            System.out.println("RAN");

            ref.getFPM().getCM().setForum(comp.getForum());
            ref.getFPM().getCC().updateMouseListener();
            ref.changePage("FORUM_PAGE");
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
