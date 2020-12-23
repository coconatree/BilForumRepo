package AuthFrame.LoginPage;

import MainFrame.CustomComponents.CustomJPanel;
import Static.Colors;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.MatteBorder;

public class LoginPageView extends CustomJPanel implements ILoginPageView {

    @Override
    public void update(LoginPageModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    public void init( LoginPageModel model )
    {
        MigLayout layout1 = new MigLayout("inset 5 5 5 5", String.format("[%d]10[grow]", model.getSc().getWIDTH_RATIO() * 10), "[grow]");
        model.getPanel1().setLayout(layout1);

        model.getPanel1().add(model.getUsernameLabel(), "grow");
        model.getPanel1().add(model.getUserNameTextField(), "grow");

        /***********************************************************************/

        MigLayout layout2 = new MigLayout("inset 5 5 5 5", String.format("[%d]10[grow]", model.getSc().getWIDTH_RATIO() * 10), "[grow]");
        model.getPanel2().setLayout(layout2);

        model.getPanel2().add(model.getPassWordLabel(), "grow");
        model.getPanel2().add(model.getPasswordField(), "grow");

        /***********************************************************************/

        MigLayout layout3 = new MigLayout("inset 5 5 5 5", "[grow]5[grow]", "[grow]");
        model.getPanel3().setLayout(layout3);
        model.getPanel3().add(model.getLoginButton(), "grow");
        model.getPanel3().add(model.getRegisterButton(), "grow");

        /***********************************************************************/

        MigLayout layout4 = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");
        model.getPanel4().setLayout(layout4);
        model.getPanel4().add(model.getForgotButton(), "grow");

        /***********************************************************************/

        MigLayout topLayout = new MigLayout("", "[grow]", "[grow][grow]");
        model.getPanelTop().setLayout(topLayout);
        model.getPanelTop().add(model.getPanel1(), "grow, wrap");
        model.getPanelTop().add(model.getPanel2(), "grow, wrap");

        MigLayout botLayout = new MigLayout("", "[grow]", "[grow][grow]");
        model.getPanelBot().setLayout(botLayout);
        model.getPanelBot().add(model.getPanel3(), "grow, wrap");
        model.getPanelBot().add(model.getPanel4(), "grow, wrap");

        /************************************************************************/

        MigLayout layout5 = new MigLayout("", "[grow]", String.format("[%d]%d[%d]",  model.getSc().getHEIGHT_RATIO() * 20, model.getSc().getWIDTH_RATIO() * 32, model.getSc().getHEIGHT_RATIO() * 20));
        model.getPanel5().setLayout(layout5);

        model.getPanel5().add(model.getPanelTop(), "grow, wrap");
        model.getPanel5().add(model.getPanelBot(), "grow");

        /************************************************************************/

        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]","[grow]");
        this.setLayout(layout);
        this.add(model.getPanel5(), "grow");

        this.setBorder( new MatteBorder(0, 2, 0, 0, Colors.SECONDARY_COLOR));
    }
}
