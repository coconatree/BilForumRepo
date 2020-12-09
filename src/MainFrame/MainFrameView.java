package MainFrame;

import MainFrame.CustomComponents.CustomJFrame;
import net.miginfocom.swing.MigLayout;

import java.awt.*;

public class MainFrameView extends CustomJFrame implements IMainFrameView
{
    @Override
    public void update(MainFrameModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    /*******************************************************************************************/

    private void init(MainFrameModel model)
    {
        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", String.format("[%d]15[grow]", model.getSc().getHEIGHT_RATIO() * 10));
        this.setLayout(layout);

        /******************************************************************/

        model.setCardLayout(new CardLayout());

        model.getCardPanel().setLayout(model.getCardLayout());

        model.getCardPanel().add(model.getMMM().getView(), "MAIN_MENU");
        model.getCardPanel().add(model.getFPM().getView(), "FORUM_PAGE");
        model.getCardPanel().add(model.getPostCreationPageModel().getView(), "POST_CREATION_PAGE");
        model.getCardPanel().add(model.getProfilePageModel().getView(), "PROFILE_PAGE");

        /***** TEST *****/

        model.getPanel().add(model.getLabelTemp());
        model.getCardPanel().add(model.getPanel(), "PANEL_TEMP");

        /******************************************************************/

        model.getCardLayout().show(model.getCardPanel(), "MAIN_MENU");

        /******************************************************************/

        this.add(model.getNVM().getView(), "grow, wrap");
        this.add(model.getCardPanel(), "grow");

        /******************************************************************/

        this.setMinimumSize(new Dimension(model.getSc().getWIDTH(), model.getSc().getHEIGHT()));
    }
}