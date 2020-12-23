package MainFrame.Pages.MainMenu.TopPosts;

import MainFrame.CustomComponents.CustomJPanel;
import Static.Colors;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * __The view class of Top Posts Pane in the main menu (Left Pane) ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */
public class TopPostsView extends CustomJPanel implements ITopPostsView {

    @Override
    public void update(TopPostsModel model) {
        init( model );
    }

    private void init( TopPostsModel model){

        MigLayout layout = new MigLayout( "inset 0 0 10 0","[grow]", String.format("[%d]10[grow]7[grow]7[grow]7[grow]7[grow]7[grow]7[grow]7[grow]7[grow]7[grow]", model.getSc().getHEIGHT_RATIO() * 5));
        this.setLayout( layout );

        this.add( model.getTopPostsLabel(),"center, wrap");

        for ( int i = 0 ; i < 10 ; i++)
        {
            this.add(model.getCMP().get(i), "grow, wrap");
        }

        this.setOpaque(false);

        // this.setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));
    }
}
