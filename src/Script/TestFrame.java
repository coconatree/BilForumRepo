package Script;

import Script.ViewComponent.PanelComp;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        PanelComp panel = new PanelComp();

        panel.setData("Merhaba Arkadaslar. <CodeBlock> AAAAAA AAAAAAAAAAAA AAAAAA </CodeBlock> BBBBB ");

        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[grow][grow]");

        frame.setLayout(layout);

        JButton changer = new JButton("Change");

        changer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run()
                    {
                        panel.setData("Merhaba Arkadaslar. <CodeBlock> CCCCCCCC </CodeBlock> DDDDD ");
                        panel.update();
                    }
                });
            }
        });

        panel.update();

        frame.add(changer, "grow, wrap");
        frame.add(panel, "grow");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(new Dimension(950, 650));
    }
}
