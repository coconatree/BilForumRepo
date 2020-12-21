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

        boolean valid = true;

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

                    Post post1 = new Post(
                            "1016",
                            "0",
                            "0",
                            titleText,
                            contentText,
                            "emre",
                            "----", tagsText
                    );

                    PostModel modelTemp = new PostModel(post1);
                    PostView viewTemp = new PostView();

                    modelTemp.setView(viewTemp);

                    try
                    {
                        PCCenterModel.getRef().getFPM().getCM().wake();

                        String code = APIConnection.httpPOST(post1,currentForum);

                        PCCenterModel.getRef().getFPM().getCM().wake();
                        System.out.println(code);
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
