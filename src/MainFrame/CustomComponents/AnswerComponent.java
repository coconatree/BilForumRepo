package MainFrame.CustomComponents;

import Script.ViewComponent.SyntaxComponentModel;
import Script.ViewComponent.SyntaxComponentView;
import Static.Colors;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class AnswerComponent extends JComponent
{
    private JLabel title;

    private SyntaxComponentModel model;
    private SyntaxComponentView  view;

    public AnswerComponent(String title, String data)
    {
        this.title = new CustomJLabel();
        this.title.setText(title + " 's Answer");
        this.title.setFont(Fonts.TITLE_FONT);

        this.model = new SyntaxComponentModel(data);
        this.view  = new SyntaxComponentView();

        this.model.setView(this.view);

        MigLayout layout = new MigLayout("inset 0 0 0 0", "[grow]", "[20]5[grow]");
        this.setLayout(layout);

        this.title.setOpaque(false);

        this.add(this.title, "center, wrap");
        this.add(this.model.getView(), "grow");
    }
}
