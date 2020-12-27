package AuthFrame.EmailPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class EmailPageView extends CustomJPanel implements IEmailPageView{

    @Override
    public void update( EmailPageModel model ) {
        this.init(model);
        this.validate();
        this.repaint();
    }

    public void init( EmailPageModel model )
    {
        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]5[grow]", "[grow]");
        model.getPanel().setLayout(layout);
        model.getPanel().add(model.getCodeLabel(),"grow, wrap");
        model.getPanel().add(model.getCodeTextField(),"grow");

        /***********************************************************************/

        MigLayout layout2 = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");
        model.getPanel2().setLayout(layout2);
        model.getPanel2().add(model.getCodeVerifyButton(), "grow,wrap");

        /**************************************************************************************/

        MigLayout topLayout = new MigLayout("", "[grow]", "[grow][grow]");
        model.getPanelTop().setLayout(topLayout);
        model.getPanelTop().add(model.getPanel(), "grow");

        MigLayout botLayout = new MigLayout("", "[grow]", "[grow][grow]");
        model.getPanelBot().setLayout(botLayout);
        model.getPanelBot().add(model.getPanel2(), "grow,wrap");

        /******************************************************************************************/

        MigLayout layout3 = new MigLayout("", "[grow]", String.format("[%d]%d[%d]",  model.getSc().getHEIGHT_RATIO() * 20, model.getSc().getWIDTH_RATIO() * 32, model.getSc().getHEIGHT_RATIO() * 20));
        model.getPanel3().setLayout(layout3);

        model.getPanel3().add(model.getPanelTop(), "grow, wrap");
        model.getPanel3().add(model.getPanelBot(), "grow");

        this.add(model.getPanel3(),"grow");
    }
}
