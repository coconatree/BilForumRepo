package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import Script.ViewComponent.SyntaxComponentModel;
import Script.ViewComponent.SyntaxComponentView;
import PojoClasses.Post;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class POCenterModel implements IPOCenterModel {

    private IPOCenterView centerView;
    private SizeConstants sizeConstants;

    private Post post;

    private SyntaxComponentModel syntaxModel;
    private SyntaxComponentView  syntaxView;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    /**********-ParentPanel1-******************/
    private JPanel panel1Top;
    private JPanel panel1Center;
    private JPanel panel1Bottom;
    /**************Top*****************/
    private JButton voteUpButton ;
    private JButton voteDownButton ;
    private JLabel pointsLabel ;
    private JLabel titleLabel ;
    private JLabel dateLabel ;
    /**************-Center-**********************/
    private JLabel contentLabel ;
    /******************-Bottom-******************/
    /************************************/
    /**********-ParentPanel2-******************/
    /************************************/
    /**********-ParentPanel3-******************/
    /************************************/
    /**********-ParentPanel4-******************/
    private JButton editButton;
    private JButton deleteButton;
    private JButton postButton;
    /************************************/

    public POCenterModel() {
        this.init();
    }

    public void setPostDetailsContents() {
        pointsLabel.setText("POINTS: "+String.valueOf(post.getVotes()));
        titleLabel.setText("TITLE: "+post.getTitle());
        voteUpButton.setText("+");
        voteDownButton.setText("-");
        dateLabel.setText(post.getDate());
        contentLabel.setText("POST CONTENT : " + post.getContent());
    }

    private void init()
    {
        System.out.println("POCenterModel init edildi...");
        this.sizeConstants = new SizeConstants();

        this.panel1 = new CustomJPanel();
        this.panel1Top = new CustomJPanel();
        this.panel1Center = new CustomJPanel();
        this.panel1Bottom = new CustomJPanel();

        this.voteUpButton = new CustomJButton();
        this.voteDownButton = new CustomJButton();
        this.pointsLabel = new JLabel();
        this.pointsLabel.setFont(new Font("Monaco", Font.BOLD, 12));
        this.titleLabel = new JLabel();
        this.dateLabel = new JLabel();
        this.contentLabel = new JLabel();


        this.editButton = new CustomJButton();
        this.deleteButton = new CustomJButton();
        this.postButton = new CustomJButton();
        editButton.setText("edit");
        deleteButton.setText("delete");
        postButton.setText("post");


        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();
        this.panel4 = new CustomJPanel();

        this.panel1.setBackground(Color.red);
        this.panel2.setBackground(Color.green);
        this.panel3.setBackground(Color.cyan);
        this.panel4.setBackground(Color.yellow);

        //this.syntaxModel = new SyntaxComponentModel("");
        //this.syntaxView  = new SyntaxComponentView();
        //this.syntaxModel.setView(this.syntaxView);
    }

    /*public void setContent()
    {
        this.syntaxModel = new SyntaxComponentModel(this.post.getContent());
        this.syntaxModel.setView(this.syntaxView);
    }*/

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

    /*public SyntaxComponentModel getSyntaxModel() {
        return syntaxModel;
    }*/

    public JPanel getPanel1() { return panel1; }

    public JPanel getPanel2() {return panel2;  }

    public JPanel getPanel3() { return panel3; }

    public JPanel getPanel4() { return panel4; }

    public JPanel getPanel1Top() {return panel1Top;}

    public JPanel getPanel1Center() {return panel1Center;}

    public JPanel getPanel1Bottom() {return panel1Bottom; }

    public JButton getVoteUpButton() { return voteUpButton; }

    public JButton getVoteDownButton() { return voteDownButton; }

    public JLabel getPointsLabel() { return pointsLabel; }

    public JLabel getTitleLabel() { return titleLabel; }

    public JLabel getDateLabel() { return dateLabel; }

    public JLabel getContentLabel() { return contentLabel; }

    public JButton getEditButton() { return editButton; }

    public JButton getDeleteButton() { return deleteButton; }

    public JButton getPostButton() { return postButton; }
}
