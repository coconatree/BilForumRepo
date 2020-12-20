package AuthFrame.LoginPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

public class LoginPageView extends CustomJPanel implements ILoginPageView {

    @Override
    public void update(LoginPageModel model) {

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

        MigLayout layout5 = new MigLayout("", "[grow]", String.format("[%d]15[%d]50[%d]15[%d]",  model.getSc().getHEIGHT_RATIO() * 10, model.getSc().getHEIGHT_RATIO() * 10,  model.getSc().getHEIGHT_RATIO() * 10,  model.getSc().getHEIGHT_RATIO() * 10));
        model.getPanel5().setLayout(layout5);

        model.getPanel5().add(model.getPanel1(), "grow, wrap");
        model.getPanel5().add(model.getPanel2(), "grow, wrap");
        model.getPanel5().add(model.getPanel3(), "grow, wrap");
        model.getPanel5().add(model.getPanel4(), "grow, wrap");

        /************************************************************************/

        MigLayout layout = new MigLayout("debug, inset 5 5 5 5", "[grow]","[grow]");
        this.setLayout(layout);
        this.add(model.getPanel5(), "grow");
    }
}
