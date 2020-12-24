package Script;


import Script.ViewComponent.SyntaxComponentModel;
import Script.ViewComponent.SyntaxComponentView;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class TestFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        String data = "Merhaba Arkadaslar. <CodeBlock> AAAAAA AAAAAAAAAAAA AAAAAA </CodeBlock> BBBBB ";

        SyntaxComponentView compView = new SyntaxComponentView();
        SyntaxComponentModel compModel = new SyntaxComponentModel(data);

        compModel.setView(compView);

        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[grow][grow]");

        frame.setLayout(layout);

        frame.add(new JLabel("TEST FIELD"), "grow, wrap");
        frame.add(compModel.getView(), "center");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(new Dimension(950, 650));
    }
}
