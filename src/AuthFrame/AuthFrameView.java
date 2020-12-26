package AuthFrame;

import MainFrame.CustomComponents.CustomJFrame;
import Static.Colors;
import Utility.CenterFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthFrameView extends CustomJFrame implements IAuthFrameView
{
    private AuthFrameModel model;

    @Override
    public void update(AuthFrameModel model)
    {
        this.model = model;

        this.init(model);
        this.validate();
        this.repaint();
    }

    private void init(AuthFrameModel model)
    {
        MigLayout layout = new MigLayout("", String.format("[grow]5[%d]", model.getSc().getWIDTH_RATIO() * 65), "[grow]");

        this.setLayout(layout);

        model.getCardPanel().setLayout(model.getCardLayout());

        model.getCardPanel().add(model.getLoginPageModel().getView(), "LOGIN_PAGE");
        model.getCardPanel().add(model.getRegisterPageModel().getView(), "REGISTER_PAGE");
        model.getCardPanel().add(model.getEmailPageModel().getView(), "EMAIL_PAGE");
        model.getCardPanel().add(model.getForgetPasswordPageModel().getView(), "PASSWORD_PAGE");

        model.getCardLayout().show(model.getCardPanel(), "LOGIN");

        this.add(model.getLeftPanel(), "grow");
        this.add(model.getCardPanel(), "grow");

        this.setMinimumSize(new Dimension(model.getSc().getWIDTH(), model.getSc().getHEIGHT()));
        CenterFrame.centreWindow(this);

        this.getContentPane().setBackground(Colors.MAIN_COLOR);
        this.setResizable(false);
    }

    class NavListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    model.getCardLayout().show(model.getCardPanel(), "REGISTER");
                }
            });

        }
    }
}
