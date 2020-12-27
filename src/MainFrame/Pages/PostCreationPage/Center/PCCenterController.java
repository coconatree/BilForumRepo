package MainFrame.Pages.PostCreationPage.Center;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomForumComponent;
import MainFrame.MainFrameModel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.ForumPage.Center.Post.PostView;
import MainFrame.Pages.ProfilePage.Center.PPCenterModel;
import PojoClasses.Forum;
import PojoClasses.Post;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PCCenterController
{
    IPCCenterView  postCreationCenterView;
    PCCenterModel postCreationCenterModel;

    MainFrameModel ref;


    public PCCenterController(IPCCenterView postCreationCenterView, PCCenterModel postCreationCenterModel, MainFrameModel ref)
    {
        this.postCreationCenterView = postCreationCenterView;
        this.postCreationCenterModel = postCreationCenterModel;

        this.ref = ref;

        this.postCreationCenterModel.addActionListenerToPostBtn(new PostCreationPagePostButtonListener());
    }

    class PostCreationPagePostButtonListener implements ActionListener
    {
        String titleText;
        String contentText;
        String tagsText;
        String currentForum;
        String date;
        int index;

        @Override
        public void actionPerformed(ActionEvent e)
        {

            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    JButton source = (JButton) e.getSource();

                    String name = source.getName();

                    titleText = postCreationCenterModel.getTitleField().getText();
                    contentText = postCreationCenterModel.getContentInput().getText();
                    tagsText = postCreationCenterModel.getTagsTextField().getText();
                    currentForum = PCCenterModel.getRef().getFPM().getCM().getCurrentForum();

                    postCreationCenterModel.getTitleField().setText("");
                    postCreationCenterModel.getContentInput().setText("");
                    postCreationCenterModel.getTagsTextField().setText("");

                    if(name.equals("UPDATE"))
                    {
                        try
                        {
                            Post post1 = new Post(
                                    APIConnection.getID(currentForum + "Post"),
                                    postCreationCenterModel.getPost().getViews(),
                                    postCreationCenterModel.getPost().getVotes(),
                                    titleText,
                                    contentText,
                                    ref.getCurrentUser().getUsername(),
                                    postCreationCenterModel.getPost().getDate(),
                                    tagsText.replace('#', ','),
                                    postCreationCenterModel.getPost().getComments(),
                                    postCreationCenterModel.getPost().getAnswers()
                            );

                            APIConnection.updatePost(post1);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        ref.update();
                        ref.changePage("MAIN_PAGE");
                    }
                    else
                        {
                            try
                            {
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                Date date = new Date();

                                String strDate = formatter.format(date);

                                PCCenterModel.getRef().getFPM().getCM().wake();

                                Post post1 = new Post(
                                        APIConnection.getID(currentForum + "Post"),
                                        "0",
                                        "0",
                                        titleText,
                                        contentText,
                                        ref.getCurrentUser().getUsername(),
                                        strDate,
                                        tagsText.replace('#', ','),
                                        "",
                                        ""
                                );

                                index = post1.getId().indexOf("-");

                                PostModel modelTemp = new PostModel(post1);
                                PostView viewTemp = new PostView();

                                modelTemp.setView(viewTemp);

                                if (((JButton) e.getSource()).getText().equals("Update"))
                                {
                                    APIConnection.updatePost(post1);
                                    postCreationCenterModel.changeToPostMode();
                                }
                                else { APIConnection.httpPOST(post1, currentForum); }

                                PCCenterModel.getRef().getFPM().getCM().wake();

                            }
                            catch (Exception exception)
                            {
                                exception.printStackTrace();
                                exception.getMessage();
                            }

                            ref.getCardLayout().show(ref.getCardPanel(), "FORUM_PAGE");
                            ref.getFPM().getCC().updateMouseListener();
                            ref.getFPM().getCM().update();
                        }
                }
            });
        }
    }
}
