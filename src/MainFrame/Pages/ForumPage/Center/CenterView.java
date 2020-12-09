package MainFrame.Pages.ForumPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import net.miginfocom.swing.MigLayout;

public class CenterView extends CustomJPanel implements ICenterView
{
    @Override
    public void update(CenterModel model)
    {
        this.init(model);
    }

    private void init(CenterModel model)
    {
        MigLayout layout = new MigLayout("inset 5 15 5 15", "[grow]", this.stringGenerator(model.getPostModels().size(), model));
        this.setLayout(layout);

        for(PostModel mdl : model.getPostModels())
        {
            this.add(mdl.getView(), "grow, wrap");
        }
    }

    private String stringGenerator(int number, CenterModel model)
    {
        String str = "";

        for(int i = 0; i < number; i++)
        {
            str += String.format("[%d]", model.getSc().getHEIGHT_RATIO() * 10);

            if(i != number)
            {
                str += "10";
            }
        }
        return str;
    }
}
