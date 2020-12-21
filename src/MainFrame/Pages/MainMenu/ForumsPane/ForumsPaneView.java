package MainFrame.Pages.MainMenu.ForumsPane;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class ForumsPaneView extends CustomJPanel implements IForumsPaneView {

    @Override
    public void update(ForumsPaneModel model)
    {
        init( model );
    }

    private void init( ForumsPaneModel model)
    {
        MigLayout layout = new MigLayout( "inset 5 10 5 10", "[grow]", stringGenerator( model.getForumList().size(), model ));

        this.setLayout( layout );

        for ( int i = 0 ; i < model.getForumList().size() ; i++)
        {
            this.add( model.getForumList().get(i).getView(), "grow, wrap" );
        }
    }

    private String stringGenerator(int k , ForumsPaneModel model){

        String str = "";

        for (int i = 0 ; i < k ; i++){
            str += String.format("[%d]" , model.getSc().getHEIGHT_RATIO() * 10);

            if ( i < k - 1)
                str += "5" ;

        }
        return str ;
    }

    @Override
    public String toString()
    {
        return "Hello from the pane";
    }
}