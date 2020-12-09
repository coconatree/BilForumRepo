package MainFrame.Pages.MainMenu.ForumsPane.Forum;

import MainFrame.CustomComponents.CustomJPanel;
import Static.SizeConstants;
import PojoClasses.Forum;
import javax.swing.*;
/**
 * __ForumModel class ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */

public class ForumModel implements IForumModel{

    private IForumView forumView;
    private Forum forumObj ;
    private SizeConstants sc ;

    /*******************************************************************************************/

    JLabel titleLabel;
    JLabel postCountLabel;
    JLabel creationDateLabel;

    /*******************************************************************************************/

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    /*******************************************************************************************/

    String titleText;
    String creationDate;
    int postCount ;

    /*******************************************************************************************/

    public ForumModel( Forum forumObj)
    {
        this.forumObj = forumObj;
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.initText();
        this.initLabels();
        this.initPanels();
    }

    private void initText()
    {
        titleText = forumObj.getTitle();
        creationDate = forumObj.getCreationDate();
        postCount = forumObj.getPostCount();
    }

    private void initLabels()
    {
        titleLabel = new JLabel("Title: " + titleText);
        creationDateLabel = new JLabel("Creation Date: " + creationDate);
        postCountLabel = new JLabel("Total Post Count: " + postCount);
    }

    private void initPanels(){
        panel1 = new CustomJPanel();
        panel2 = new CustomJPanel();
        panel3 = new CustomJPanel();
    }
    /*******************************************************************************************/

    @Override
    public void update() {
        this.forumView.update(this);
    }

    @Override
    public void setView(IForumView view) {
        this.forumView = view ;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel)this.forumView;
    }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    public JLabel getCreationDateLabel() {
        return creationDateLabel;
    }

    public JLabel getPostCountLabel() {
        return postCountLabel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }
}
