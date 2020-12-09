package AuthFrame.AuthPages.RegisterPage;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

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
        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]", "[grow]");
        this.setLayout(layout);
        this.add(model.getUsername(),"grow, wrap");
        this.add(model.getUsernameF(),"grow, wrap");
        this.add(model.getEmail(),"grow, wrap");
        this.add(model.getEmailF(),"grow, wrap");
        this.add(model.getPassword(),"grow, wrap");
        this.add(model.getPasswordF(),"grow, wrap");
        this.add(model.getPasswordR(),"grow, wrap");
        this.add(model.getPasswordRF(),"grow, wrap");
        this.add(model.getRegisterBTN(),"grow");
    }



}
