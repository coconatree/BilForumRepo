package MainFrame.Navbar;

import MainFrame.CustomComponents.CustomJPanel;

import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

public class NavbarView extends CustomJPanel implements INavbarView
{
    @Override
    public void update(NavbarModel model)
    {
        this.init(model);
        this.validate();
        this.repaint();
    }

    /*******************************************************************************************/

    private void init(NavbarModel model)
    {
        MigLayout layout = new MigLayout("inset 15 20 15 20", String.format("[%d]15[grow]15[%d]", model.getSc().getWIDTH_RATIO() * 10, model.getSc().getWIDTH_RATIO() * 10), "[grow]");
        this.setLayout(layout);

        this.setBackground(model.getBackground_color());

        this.setupPanel1(model);
        this.setupPanel2(model);
        this.setupPanel3(model);

        this.add(model.getlPanel(), "grow");
        this.add(model.getsPanel(), "grow");
        this.add(model.getpPanel(), "grow");
    }

    private void setupPanel1(NavbarModel model)
    {
        MigLayout layout1 = new MigLayout("fillx, inset 5 5 5 5", "[grow]", "[grow]");
        model.getlPanel().setLayout(layout1);

        CC cc = new CC();
        cc.alignX("center").spanX();

        model.getlPanel().add(model.getLogoLabel(), cc);
    }

    private void setupPanel2(NavbarModel model)
    {
        MigLayout layout2 = new MigLayout("", String.format("[%d][%d][%d][grow][%d]", model.getSc().getWIDTH_RATIO()* 2, model.getSc().getWIDTH_RATIO()* 2, model.getSc().getWIDTH_RATIO() * 2,  model.getSc().getWIDTH_RATIO() * 2),"[grow]");
        model.getsPanel().setLayout(layout2);

        model.getsPanel().add(model.getbBtn(), "growx");
        model.getsPanel().add(model.getnBtn(), "growx");
        model.getsPanel().add(model.getrBtn(), "growx");
        model.getsPanel().add(model.getsTF(),  "growx");
        model.getsPanel().add(model.getsBtn(), "growx");
    }

    private void setupPanel3(NavbarModel model)
    {
        MigLayout layout3 = new MigLayout("inset 15 15 15 15", "[grow][grow]", "[grow]");
        model.getpPanel().setLayout(layout3);

        model.getpPanel().add(model.getVoteLabel(), "grow");
        model.getpPanel().add(model.getProfLabel(), "grow");
    }
}
