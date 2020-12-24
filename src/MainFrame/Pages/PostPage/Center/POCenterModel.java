package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import Script.ViewComponent.SyntaxComponentModel;
import Script.ViewComponent.SyntaxComponentView;
import PojoClasses.Post;
import Static.SizeConstants;

import javax.swing.*;

public class POCenterModel implements IPOCenterModel {

    private IPOCenterView centerView;
    private SizeConstants sizeConstants;

    private Post post;

    private SyntaxComponentModel syntaxModel;
    private SyntaxComponentView  syntaxView;

    public POCenterModel() {
        this.init();
    }

    private void init()
    {
        this.sizeConstants = new SizeConstants();

        this.syntaxModel = new SyntaxComponentModel("");
        this.syntaxView  = new SyntaxComponentView();
        this.syntaxModel.setView(this.syntaxView);
    }

    public void setContent()
    {
        this.syntaxModel = new SyntaxComponentModel(this.post.getContent());
        this.syntaxModel.setView(this.syntaxView);
    }

    public void setPost(Post post)
    {
        this.post = post;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel) this.centerView;
    }

    @Override
    public void setView( IPOCenterView view) {
        this.centerView = view;
    }

    @Override
    public void update() {
        this.centerView.update(this);
    }

    public SizeConstants getSc()
    {
        return sizeConstants;
    }

    public SyntaxComponentModel getSyntaxModel() {
        return syntaxModel;
    }
}
