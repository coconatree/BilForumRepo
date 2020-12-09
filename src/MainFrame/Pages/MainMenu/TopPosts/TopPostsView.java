package MainFrame.Pages.MainMenu.TopPosts;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;
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

        MigLayout layout = new MigLayout( "inset 15 15 15 15","[grow]", this.stringGenerator(10 , model) );
        this.setLayout( layout );

        this.add( model.getTopPostsLabel()," wrap");

        for ( int i = 0 ; i < 10 ; i++)
        {
            this.add( model.getPostModels().get( i ).getView(),"grow, wrap");
        }
    }

    private String stringGenerator( int number ,TopPostsModel model){
        String str = "[100]5" ;

        for ( int i = 0 ; i < number ; i++){
            str += String.format( "[%d]",model.getSc().getHEIGHT_RATIO() * 8 );
            if ( i < number - 1)
                str += "5";
        }

        return str ;
    }
}
