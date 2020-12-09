package MainFrame.Pages.MainMenu;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends CustomJPanel implements IMainMenuView
{
    @Override
    public void update(MainMenuModel model) {

        this.init( model );
        this.validate();
        this.repaint();
    }

    private void init( MainMenuModel model)
    {
        MigLayout layout = new MigLayout("inset 15 15 15 15"
                , String.format("[%d]15[grow]15[%d]" , model.getSc().getWIDTH_RATIO() * 15 ,model.getSc().getWIDTH_RATIO() * 15)
                , "[grow]");

        this.setLayout( layout );


        // Emre

        model.getScrollPane().setViewportView(model.getForumsPaneModel().getView());

        this.addAll( model );
    }

    private void addAll( MainMenuModel model)
    {
        this.add( model.getTopPostsModel().getView(),"grow" );  // Emre
        this.add( model.getScrollPane(),"grow" );
        this.add( model.getPanelR(),"grow" );
    }
}
