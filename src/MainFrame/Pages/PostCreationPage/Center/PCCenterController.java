package MainFrame.Pages.PostCreationPage.Center;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCCenterController
{
    IPCCenterView  postCreationCenterView;
    PCCenterModel postCreationCenterModel;

    public PCCenterController(IPCCenterView postCreationCenterView, PCCenterModel postCreationCenterModel)
    {
        this.postCreationCenterView = postCreationCenterView;
        this.postCreationCenterModel = postCreationCenterModel;

        this.postCreationCenterModel.addActionListenerToPostBtn(new PostCreationPagePostButtonListener());
    }

    class PostCreationPagePostButtonListener implements ActionListener
    {
        String titleText;
        String contentText;

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

                    if(valid)
                    {
                        System.out.println("Sending to the database !!!");
                        System.out.println("Redirecting you to the forum page !!!");
                        System.out.println("-------------------------");
                        System.out.println(titleText);
                        System.out.println("-------------------------");
                        System.out.println(contentText);
                    }
                    else
                    {
                        System.out.println("Else block");
                        new JOptionPane("It is not valid.");
                    }
                }
            });
        }
    }
}
