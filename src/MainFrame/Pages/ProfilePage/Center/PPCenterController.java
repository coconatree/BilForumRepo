package MainFrame.Pages.ProfilePage.Center;

import MainFrame.MainFrameModel;
import MainLoop.Loop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PPCenterController
{
    private PPCenterView  view;
    private PPCenterModel model;

    private MainFrameModel ref;

    public  PPCenterController(PPCenterView view, PPCenterModel model, MainFrameModel ref)
    {
        this.view = view;
        this.model = model;

        this.ref = ref;

        this.model.addActionListenerToLogOut(new LogOutListener());
    }

    class LogOutListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    ref.getView().dispose();
                    System.exit(0);
                }
            });
        }
    }
}
