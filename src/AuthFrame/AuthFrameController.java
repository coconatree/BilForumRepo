package AuthFrame;

import MainLoop.Loop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthFrameController
{
    private IAuthFrameView AFV;
    private AuthFrameModel AFM;

    private Loop ref;

    public AuthFrameController(IAuthFrameView view, AuthFrameModel model, Loop ref)
    {
        this.AFV = view;
        this.AFM = model;

        this.ref = ref;
    }
}
