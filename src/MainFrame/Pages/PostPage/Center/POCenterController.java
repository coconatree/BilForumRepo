package MainFrame.Pages.PostPage.Center;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.PostComponent;
import MainFrame.MainFrameModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class POCenterController
{
    private POCenterView POCV;
    private POCenterModel POCM;

    private MainFrameModel ref;

    public POCenterController(POCenterView view, POCenterModel model, MainFrameModel ref)
    {
        this.POCV = view;
        this.POCM = model;

        this.ref = ref;

        this.POCM.addActionListenerToAddComment(new CommentClickListener());
        this.POCM.addActionListenerToDeletePost(new DeleteClickListener());
        this.POCM.addActionListenerToEditPost(new EditClickListener());
        this.POCM.addActionListenerToUpVote(new VoteUpListener());
        this.POCM.addActionListenerToDownVote(new VoteDownListener());
    }

    class CommentClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    POCM.getPost().addComment(ref.getCurrentUser().getUsername(), POCM.getCommentTf().getText());

                    try
                    {
                        APIConnection.updatePost(POCM.getPost());
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    POCM.update();
                }
            });
        }
    }

    class DeleteClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        System.out.println("DELETE");
                        APIConnection.delete(POCM.getPost().getId());
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    ref.update();
                    ref.changePage("MAIN_MENU");
                }
            });
        }
    }

    class EditClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    System.out.println("EDIT");

                    ref.getPostCreationPageModel().getPCCenterModel().changeToEditMode(POCM.getPost());
                    ref.getPostCreationPageModel().getPCCenterModel().update();
                    ref.changePage("POST_CREATION_PAGE");
                }
            });
        }
    }

    class VoteUpListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    POCM.getPost().incrementVotes();
                }
            });
        }
    }

    class VoteDownListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    POCM.getPost().decrementVotes();
                }
            });
        }
    }
}
