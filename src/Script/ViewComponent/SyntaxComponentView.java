package Script.ViewComponent;

import MainFrame.CustomComponents.CustomJPanel;
import Script.Engine.Token;
import Static.Colors;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class SyntaxComponentView extends CustomJPanel
{
    public void update(SyntaxComponentModel model)
    {
        this.init(model);
        this.revalidate();
        this.repaint();
    }

    private void init(SyntaxComponentModel model)
    {
        MigLayout layout = new MigLayout("center, inset 0 0 0 0", "[grow]", model.getRowCC(model.getTotalWrap()));
        this.setLayout(layout);

        this.renderer(model);
        this.setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));
    }

    private void clear()
    {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    private void renderer(SyntaxComponentModel model)
    {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("RENDERER STARTED");
        System.out.println("----------------------------------------------------------------------");


        this.clear();

        for(int i = 0; i < model.getTokenList().size(); i++)
        {
            System.out.println(model.getTokenList().get(i).getData().getText());

            if(!(model.getTokenList().get(i).getData().getText().equals("")))
            {
                if(model.getTokenList().get(i).getCc().equals("wrap"))
                {
                    model.getPanel().add(model.getTokenList().get(i).getData());
                    this.add(model.getPanel(), "wrap");
                    model.resetPanel(false);
                    model.getPanel().setLayout(new FlowLayout(FlowLayout.RIGHT));

                    if(i == model.getTokenList().size() - 2)
                    {
                        model.getPanel().add(model.getTokenList().get(i + 1).getData());
                    }
                }
                else if(model.getTokenList().get(i).getCc().equals("wrap,code") || model.getTokenList().get(i).getCc().equals("code"))
                {
                    model.getPanel().add(model.getTokenList().get(i).getData());
                    this.add(model.getPanel(), "wrap");
                    model.resetPanel(true);
                    model.getPanel().setLayout(new FlowLayout(FlowLayout.RIGHT));

                }
                else if(model.getTokenList().get(i).getCc().equals("wrap,code_end") || model.getTokenList().get(i).getCc().equals("code_end"))
                {
                    model.getPanel().add(model.getTokenList().get(i).getData());
                    this.add(model.getPanel(), "wrap");
                    model.resetPanel(false);
                    model.getPanel().setLayout(new FlowLayout(FlowLayout.RIGHT));
                }
                else { model.getPanel().add(model.getTokenList().get(i).getData()); }
            }
            else { continue;}
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("RENDERER ENDED");
        System.out.println("----------------------------------------------------------------------");
    }
}
