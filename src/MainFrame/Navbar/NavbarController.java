package MainFrame.Navbar;

import APIConnection.APIConnection;
import MainFrame.MainFrameModel;
import PojoClasses.Post;
import Utility.SearchPopUp;

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

    private int currentPosition;
    private Boolean bool;

    private MainFrameModel ref;

    public NavbarController(INavbarView NBV, NavbarModel NBM, MainFrameModel ref)
    {
        this.NBV = NBV;
        this.NBM = NBM;

        this.currentPosition = 0;
        this.bool = true;

        this.ref = ref;

        this.NBM.addMouseListenerToLogoLabel(new LogoListener());
        this.NBM.addActionListenerToBackBtn(new BackListener());
        this.NBM.addActionListenerToRefreshBtn(new RefreshListener());
        this.NBM.addMouseListenerToProfile(new ProfileNavListener());
        this.NBM.addActionListenerToSearchBtn(new SearchListener());
    }

    class SearchListener implements ActionListener
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
                        ArrayList<Post> postList = APIConnection.search(NBM.getsTF().getText().replace("#", ","));

                        SearchPopUp popUp = new SearchPopUp(postList);

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    class ProfileNavListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    NBM.getRef().changePage("PROFILE_PAGE");
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

    class BackListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    ArrayList<String> list = NBM.getRef().getPageList();

                    if(2 <= list.size())
                    {
                        NBM.getRef().changePage(NBM.getRef().getPageList().get(NBM.getRef().getPageList().size() - 2), true);
                        NBM.getRef().getPageList().remove(NBM.getRef().getPageList().size() - 1);
                    }
                    else
                        {
                            System.out.println("Size to small !!!");
                        }
                }
            });
        }
    }

    /********************************************************************************/

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
                    NBM.getRef().getFPM().getCM().wake();
                    NBM.getRef().getFPM().getCM().update();
                    NBM.getRef().update();
                }
            });
        }
    }

    /********************************************************************************/

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
                    NBM.getRef().changePage("MAIN_MENU");
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
}
