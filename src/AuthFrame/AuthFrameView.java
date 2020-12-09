package AuthFrame;

import MainFrame.CustomComponents.CustomJFrame;
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
        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");

        this.setLayout(layout);

        model.getCardPanel().setLayout(model.getCardLayout());

        this.setPanel1(model);

        model.getCardPanel().add(model.getPanel1(), "LOGIN");
        model.getCardPanel().add(model.getRegisterPageModel().getView(), "REGISTER");
        model.getCardPanel().add(model.getPanel3(), "EMAIL");

        model.getCardLayout().show(model.getCardPanel(), "LOGIN");

        this.add(model.getCardPanel(), "grow");

        this.setMinimumSize(new Dimension(model.getSc().getWIDTH(), model.getSc().getHEIGHT()));
    }

    private void setPanel1(AuthFrameModel model)
    {
        model.getPanel1().add(model.getBtn());

        model.getRegisterButton().addActionListener(new NavListener());


        model.getPanel1().add(model.getRegisterButton());
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
