package AuthFrame.RegisterPage;

import MainFrame.CustomComponents.CustomJPanel;
import Static.Colors;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.MatteBorder;

public class RegisterPageView extends CustomJPanel implements IRegisterPageView
{
    @Override
    public void update(RegisterPageModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    private void init(RegisterPageModel model)
    {
        this.setPanels(model);

        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");
        this.setLayout(layout);

        this.add(model.getGeneralPanel(), "grow");

        this.setBorder( new MatteBorder(0, 2, 0, 0, Colors.SECONDARY_COLOR));
    }

    private void setPanels(RegisterPageModel model)
    {
        MigLayout layout1 = new MigLayout("inset 0 0 0 0", "[170]5[grow]", "[grow]");
        model.getPanel1().setLayout(layout1);
        model.getPanel1().add(model.getUsername(), "grow");
        model.getPanel1().add(model.getUsernameF(), "grow");

        MigLayout layout2 = new MigLayout("inset 5 5 5 5", "[170][grow]", "[grow]");
        model.getPanel2().setLayout(layout2);
        model.getPanel2().add(model.getEmail(), "grow");
        model.getPanel2().add(model.getEmailF(), "grow");

        MigLayout layout3 = new MigLayout("inset 5 5 5 5", "[170][grow]", "[grow]");
        model.getPanel3().setLayout(layout3);
        model.getPanel3().add(model.getPassword(), "grow");
        model.getPanel3().add(model.getPasswordF(), "grow");

        MigLayout layout4 = new MigLayout("inset 5 5 5 5", "[170][grow]", "[grow]");
        model.getPanel4().setLayout(layout4);
        model.getPanel4().add(model.getPasswordR(), "grow");
        model.getPanel4().add(model.getPasswordRF(), "grow");

        MigLayout layout5 = new MigLayout("inset 15 15 15 15 ,inset 5 5 5 5", "[grow]5[grow]", "[grow]");
        model.getPanel5().setLayout(layout5);

        model.getPanel5().add(model.getLBtn(), "grow");
        model.getPanel5().add(model.getRegisterBTN(), "grow");

        MigLayout generalLayout = new MigLayout("inset 0 0 0 0", "[grow]", String.format("[%d]15[%d]15[%d]15[%d]150[%d]", model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7, model.getSc().getHEIGHT_RATIO() * 7));
        model.getGeneralPanel().setLayout(generalLayout);
        model.getGeneralPanel().add(model.getPanel1(), "grow, wrap");
        model.getGeneralPanel().add(model.getPanel2(), "grow, wrap");
        model.getGeneralPanel().add(model.getPanel3(), "grow, wrap");
        model.getGeneralPanel().add(model.getPanel4(), "grow, wrap");
        model.getGeneralPanel().add(model.getPanel5(), "grow");
    }
}
