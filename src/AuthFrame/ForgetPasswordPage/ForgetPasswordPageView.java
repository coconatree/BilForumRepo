package AuthFrame.ForgetPasswordPage;

import AuthFrame.RegisterPage.IRegisterPageView;
import AuthFrame.RegisterPage.RegisterPageModel;
import MainFrame.CustomComponents.CustomJPanel;
import Static.Colors;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.MatteBorder;

public class ForgetPasswordPageView extends CustomJPanel implements IForgetPasswordPageView {

    @Override
    public void update(ForgetPasswordPageModel model) {
        this.init(model);
        this.validate();
        this.repaint();
    }
    private void init(ForgetPasswordPageModel model)
    {
        this.setPanels(model);

        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");
        this.setLayout(layout);

        this.add(model.getGeneralPanel(), "grow");

        this.setBorder( new MatteBorder(0, 2, 0, 0, Colors.SECONDARY_COLOR));
    }
    private void setPanels(ForgetPasswordPageModel model)
    {
        MigLayout layout1 = new MigLayout("inset 0 0 0 0", "[170]5[grow]", "[grow]");
        model.getPanel1().setLayout(layout1);
        model.getPanel1().add(model.getEmail(), "grow");
        model.getPanel1().add(model.getEmailF(), "grow");

        MigLayout layout2 = new MigLayout("inset 5 5 5 5", "[170][grow]", "[grow]");
        model.getPanel2().setLayout(layout2);
        model.getPanel2().add(model.getCode(), "grow");
        model.getPanel2().add(model.getCodeF(), "grow");

        MigLayout layout3 = new MigLayout("inset 15 15 15 15 ,inset 5 5 5 5", "[grow]5[grow]", "[grow]");
        model.getPanel3().setLayout(layout3);

        model.getPanel3().add(model.getSendBTN(), "grow");
        model.getPanel3().add(model.getCodeBTN(), "grow");

        MigLayout generalLayout = new MigLayout("inset 0 0 0 0", "[grow]", String.format("[%d]15[%d]15[%d]15[%d]150[%d]", model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7));

        model.getGeneralPanel().setLayout(generalLayout);
        model.getGeneralPanel().add(model.getPanel1(), "grow, wrap");
        model.getGeneralPanel().add(model.getPanel2(), "grow, wrap");
        model.getGeneralPanel().add(model.getPanel3(), "grow");


    }

}
