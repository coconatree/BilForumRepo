package MainFrame.Pages.PostCreationPage.Center;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomForumComponent;
import MainFrame.MainFrameModel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import MainFrame.Pages.ForumPage.Center.Post.PostView;
import PojoClasses.Forum;
import PojoClasses.Post;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    titleText = postCreationCenterModel.getTitleField().getText();
                    contentText = postCreationCenterModel.getContentInput().getText();
                    tagsText = postCreationCenterModel.getTagsTextField().getText();
                    currentForum = PCCenterModel.getRef().getFPM().getCM().getCurrentForum();

                    postCreationCenterModel.getTitleField().setText("");
                    postCreationCenterModel.getContentInput().setText("");
                    postCreationCenterModel.getTagsTextField().setText("");

                    try
                    {
                        PCCenterModel.getRef().getFPM().getCM().wake();

                        Post post1 = new Post(
                                APIConnection.getID(currentForum + "Post"),
                                "0",
                                "0",
                                titleText,
                                contentText,
                                "emre",
                                "",
                                tagsText,
                                "",
                                ""
                        );

                        index = post1.getId().indexOf("-");
                        date = post1.getId().substring(index + 1);

                        post1.setDate(date);
                        System.out.println(date);

                        PostModel modelTemp = new PostModel(post1);
                        PostView viewTemp = new PostView();

                        modelTemp.setView(viewTemp);

                        if(((JButton) e.getSource()).getText().equals("Update"))
                        {
                            APIConnection.updatePost(post1);
                            postCreationCenterModel.changeToPostMode();
                        }
                        else
                            {
                                APIConnection.httpPOST(post1, currentForum);
                            }

                        PCCenterModel.getRef().getFPM().getCM().wake();

                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        exception.getMessage();
                    }

                    // ref.getFPM().getCM().getPostModels().add(modelTemp);


                    ref.getCardLayout().show(ref.getCardPanel(), "FORUM_PAGE");

                    ref.getFPM().getCM().update();
                    ref.getFPM().getCC().updateMouseListener();
                }
            });
        }
    }
}
