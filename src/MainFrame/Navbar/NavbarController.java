package MainFrame.Navbar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavbarController
{
    private INavbarView NBV;
    private NavbarModel NBM;

    public NavbarController(INavbarView NBV, NavbarModel NBM)
    {
        this.NBV = NBV;
        this.NBM = NBM;

        this.NBM.addActionListenerToNextBtn(new ArrayChangeListener());
        this.NBM.addActionListenerToBackBtn(new PageListener());
    }

    class ArrayChangeListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    NBM.getRef().getCardLayout().show(NBM.getRef().getCardPanel(), "POST_CREATION_PAGE");
                }
            });
        }
    }

    class PageListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    NBM.getRef().getCardLayout().show(NBM.getRef().getCardPanel(), "FORUM_PAGE");
                }
            });
        }
    }
}
