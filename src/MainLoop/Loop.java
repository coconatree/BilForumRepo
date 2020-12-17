package MainLoop;

import AuthFrame.AuthFrameController;
import AuthFrame.AuthFrameModel;
import AuthFrame.AuthFrameView;
import MainFrame.CustomComponents.CustomJFrame;
import MainFrame.MainFrameController;
import MainFrame.MainFrameModel;
import MainFrame.MainFrameView;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Loop
{
    private MainFrameView MFV;
    private MainFrameModel MFM;
    private MainFrameController MFC;

    private AuthFrameView AFV;
    private AuthFrameModel AFM;
    private AuthFrameController AFC;

    private CustomJFrame frameAuth;
    private CustomJFrame frameMain;

    public void run()
    {
        this.MFV =  new MainFrameView();
        this.MFM = new MainFrameModel();
        this.MFC = new MainFrameController();

        this.MFM.setView(this.MFV);

        this.AFV = new AuthFrameView();
        this.AFM = new AuthFrameModel(this );
        this.AFC = new AuthFrameController(this.AFV, this.AFM, this);

        this.AFM.setView(this.AFV);

        this.frameAuth = this.AFM.getView();
        this.frameMain = this.MFM.getView();

        this.frameAuth.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setFrameVisible(this.frameAuth);
    }

    public static void setFrameVisible(JFrame frame)
    {
        frame.setVisible(true);
    }

    public static void closeFrame(JFrame frame)
    {
        frame.setVisible(false);
        frame.dispose();
    }

    /****************************************************************/

    public CustomJFrame getFrameAuth()
    {
        return frameAuth;
    }

    public CustomJFrame getFrameMain()
    {
        return frameMain;
    }

    public MainFrameModel getMainFrameModel()
    {
        return this.MFM;
    }
}