package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.PostComponent;
import MainFrame.MainFrameModel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class POCenterController
{
    private POCenterView POCV;
    private POCenterModel POCM;

    private MainFrameModel ref;

    public POCenterController(POCenterView view, POCenterModel model, MainFrameModel ref)
    {
        this.POCV = view;
        this.POCM = model;

        this.ref = ref;
    }
}
