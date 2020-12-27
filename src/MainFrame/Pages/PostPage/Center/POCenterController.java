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
        this.POCM.addActionListenerToUpVote(new VoteUpListener());
        this.POCM.addActionListenerToDownVote(new VoteDownListener());
        this.POCM.addActionListenerToAnswer(new AnswerListener());
    }

    class AnswerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    POCM.getPost().addAnswer(ref.getCurrentUser().getUsername(), POCM.getAnswerArea().getText());
                    POCM.getAnswerArea().setText("");
                    try
                    {
                        APIConnection.updatePost(POCM.getPost());
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    POCM.update();
                    ref.getCardLayout().show(ref.getCardPanel(), "FORUM_PAGE");
                }
            });
        }
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
                    POCM.getCommentTf().setText("");
                    try
                    {
                        APIConnection.updatePost(POCM.getPost());
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    POCM.update();
                    ref.getCardLayout().show(ref.getCardPanel(), "FORUM_PAGE");
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
                    ref.getCurrentUser().incrementPoints();
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
                    ref.getCurrentUser().decrementPoints();
                    POCM.getPost().decrementVotes();
                }
            });
        }
    }
}
