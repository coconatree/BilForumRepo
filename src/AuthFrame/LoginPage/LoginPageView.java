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
        MigLayout layout = new MigLayout("inset 200 70 200 70", "[grow]","[grow]");
        this.setLayout( layout );
        this.add( model.getUsernameLabel() , "grow");
        this.add( model.getUserNameTextField() , "wrap");
        this.add( model.getPassWordLabel() , "grow");
        this.add( model.getPassWordTextField() , "wrap");
        this.add( model.getLoginButton() , "span 2, grow , wrap");
        this.add( model.getRegisterButton() , " grow");
        this.add( model.getForgotButton() , "grow");
    }


}
