package Script.ViewComponent;

import MainFrame.CustomComponents.CustomJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class PanelComp extends CustomJPanel
{
    private SyntaxComponentView compView;
    private SyntaxComponentModel compModel;

    private String data;

    public void update()
    {
        System.out.println("Update called");

        MigLayout layout1 = new MigLayout("inset 0 0 0 0", "[grow]", "[grow]");

        this.setLayout(layout1);

        this.compView = new SyntaxComponentView();
        this.compModel = new SyntaxComponentModel(this.data);

        this.compModel.setView(compView);

        this.compModel.init(this.data);
        this.compModel.update();

        this.add(compModel.getView(), "grow");
    }

    public void setData(String data){ this.data = data; }
}
