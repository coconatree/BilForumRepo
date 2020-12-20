package MainFrame.Navbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
        this.NBM.addActionListenerToRefreshBtn(new RefreshListener());
        this.NBM.addMouseListenerToLogoLabel(new LogoListener());
    }

    class LogoListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    NBM.getRef().getCardLayout().show(NBM.getRef().getCardPanel(), "MAIN_MENU");
                }
            });
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class RefreshListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    NBM.getRef().getFPM().getCM().update();
                }
            });
        }
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
