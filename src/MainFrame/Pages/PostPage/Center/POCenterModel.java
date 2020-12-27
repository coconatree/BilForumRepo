package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.*;
import MainFrame.MainFrameModel;
import Script.ViewComponent.SyntaxComponentModel;
import Script.ViewComponent.SyntaxComponentView;
import PojoClasses.Post;
import Static.Colors;
import Static.Fonts;
import Static.SizeConstants;
import org.apache.fop.fo.FObj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;

    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;

    /**************Top*****************/

    private JButton voteUpButton ;
    private JButton voteDownButton ;

    private JLabel pointsLabel1;
    private JLabel pointsLabel2;

    private JLabel titleLabel1;
    private JLabel titleLabel2;

    /**************-Center-**********************/

    private JLabel contentLabel ;
    private JLabel dateLabel ;

    private JButton editButton;
    private JButton deleteButton;
    private JButton answerButton;

    /************************************/

    private ArrayList<String> comments;
    private ArrayList<String> anwsers;

    private MainFrameModel ref;

    /************************************/

    private JTextField commentTf;
    private JButton postComment;

    private JTextArea content;
    private JTextArea answerArea;

    private JLabel filler;
    private JLabel author;
    private JLabel date;

    public POCenterModel(MainFrameModel ref)
    {
        this.ref = ref;
        this.init();
    }

    public void setPostDetailsContents()
    {
        this.pointsLabel1.setText("Points");
        this.pointsLabel1.setFont(Fonts.TITLE_FONT);
        this.pointsLabel2.setText(String.valueOf(post.getVotes()));

        this.titleLabel2.setText(post.getTitle());
        this.titleLabel2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));

        this.voteUpButton.setText("Up Vote");
        this.voteDownButton.setText("Down Vote");

        this.author.setText("Author: " + post.getAuthor());
        this.date.setText("Date: " + post.getDate());

        this.content.setText(post.getContent());

        this.initComments();
        this.initAnswers();
    }

    private void init()
    {
        this.sizeConstants = new SizeConstants();

        /************************************/

        this.date = new CustomJLabel();
        this.author = new CustomJLabel();

        this.answerArea = new JTextArea();
        this.answerArea.setForeground(Colors.SECONDARY_COLOR);
        this.answerArea.setFont(Fonts.NORMAL_FONT);
        this.answerArea.setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));
        this.answerArea.setOpaque(false);

        this.comments = new ArrayList<>();
        this.anwsers  = new ArrayList<>();

        this.content = new JTextArea();
        this.content.setFont(Fonts.NORMAL_FONT);
        this.content.setEditable(false);
        this.content.setOpaque(false);

        this.commentTf = new CustomJTextField(5);
        this.commentTf.setEnabled(true);

        this.postComment = new CustomJButton();
        this.postComment.setText("Post Comment");

        /************************************/

        this.panel1 = new CustomJPanel();
        this.panel5 = new CustomJPanel();

        this.panel6 = new CustomJPanel();
        this.panel7 = new CustomJPanel();

        this.voteUpButton = new CustomJButton();
        this.voteDownButton = new CustomJButton();

        this.pointsLabel1 = new CustomJLabel();
        this.pointsLabel2 = new CustomJLabel();

        this.titleLabel1 = new CustomJLabel();
        this.titleLabel2 = new CustomJLabel();

        this.dateLabel = new CustomJLabel();

        this.contentLabel = new CustomJLabel();

        this.editButton = new CustomJButton();
        this.editButton.setText("Edit");

        this.answerButton = new CustomJButton();
        this.answerButton.setText("Answer");

        this.deleteButton = new CustomJButton();
        this.deleteButton.setText("Delete");

        this.panel2 = new CustomJPanel();
        this.panel3 = new CustomJPanel();
        this.panel4 = new CustomJPanel();

        /********* TEMP *********/

        this.syntaxModel = new SyntaxComponentModel("HELLO");
        this.syntaxView  = null;

        /*************************/

        this.p1 = new CustomJPanel();
        this.p2 = new CustomJPanel();
        this.p3 = new CustomJPanel();
        this.p4 = new CustomJPanel();
        this.p5 = new CustomJPanel();

        this.filler = new CustomJLabel();
    }

    /******************************************************************************/

    public void setPost(Post post)
    {
        this.post = post;
    }

    /******************************************************************************/

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
    public void update()
    {
        this.centerView.update(this);
    }

    /******************************************************************************/

    public JButton getEditButton()
    {
        if(this.post != null && this.post.getAuthor().equals(this.ref.getCurrentUser().getUsername()))
        {
            this.editButton.setEnabled(true);
        }
        else {this.editButton.setEnabled(false); }

        return editButton;
    }

    public JButton getDeleteButton()
    {
        if(this.post != null && this.post.getAuthor().equals(this.ref.getCurrentUser().getUsername()))
        {
            this.deleteButton.setEnabled(true);
        }
        else {this.deleteButton.setEnabled(false); }

        return deleteButton;
    }

    /******************************************************************************/

    public void resetComments()
    {
        System.out.println("RESET CCC");
        this.comments.clear();
    }

    public void resetAnswers()
    {
        System.out.println("RESET AAA");
        this.anwsers.clear();
    }

    /******************************************************************************/

    public void initComments()
    {
        for(String string : this.post.getComments().split("-"))
        {
            this.comments.add(string);
        }
    }

    public void initAnswers()
    {
        for(String string : this.post.getAnswers().split("-"))
        {
            this.anwsers.add(string);
        }
    }

    /**************************** ACTION LISTENERS ********************************/

    public void addActionListenerToAddComment(ActionListener AL){ this.postComment.addActionListener(AL); }
    public void addActionListenerToDeletePost(ActionListener AL){ this.deleteButton.addActionListener(AL); }
    public void addActionListenerToAnswer(ActionListener AL){ this.answerButton.addActionListener(AL); }
    public void addActionListenerToUpVote(ActionListener AL){ this.voteUpButton.addActionListener(AL); }
    public void addActionListenerToDownVote(ActionListener AL){ this.voteDownButton.addActionListener(AL); }

    /******************************************************************************/

    public JLabel getLabelWithText(String text)
    {
        JLabel ret = new CustomJLabel();
        ret.setText(text);
        return ret;
    }

    public AnswerComponent getAnswerComponent(String title, String content)
    {
        AnswerComponent comp = new AnswerComponent(title, content);
        return comp;
    }

    /******************************************************************************/

    public SizeConstants getSc()
    {
        return sizeConstants;
    }

    public JPanel getPanel1() { return panel1; }

    public JPanel getPanel2() {return panel2;  }

    public JPanel getPanel3() { return panel3; }

    public JPanel getPanel4() { return panel4; }

    public JButton getVoteUpButton() { return voteUpButton; }

    public JButton getVoteDownButton() { return voteDownButton; }

    public JLabel getDateLabel() { return dateLabel; }

    public JLabel getContentLabel() { return contentLabel; }

    public SizeConstants getSizeConstants() {
        return sizeConstants;
    }

    public Post getPost() {
        return post;
    }

    public JLabel getPointsLabel1() {
        return pointsLabel1;
    }

    public JLabel getPointsLabel2() {
        return pointsLabel2;
    }

    public JLabel getTitleLabel2() {
        return titleLabel2;
    }

    public JPanel getP1() {
        return p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public JPanel getP4() {
        return p4;
    }

    public JLabel getFiller() {
        return filler;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public JTextArea getContent() {
        return content;
    }

    public MainFrameModel getRef() {
        return ref;
    }

    public ArrayList<String> getAnwsers() {
        return anwsers;
    }

    public JTextField getCommentTf() {
        return commentTf;
    }

    public JButton getPostComment() {
        return postComment;
    }

    public JLabel getAuthor() {
        return author;
    }

    public JLabel getDate() {
        return date;
    }

    public JPanel getPanel5()
    {
        return panel5;
    }

    public JPanel getPanel6()
    {
        return panel6;
    }

    public JPanel getPanel7()
    {
        return panel7;
    }

    public JButton getAnswerButton(){ return this.answerButton; }

    public JTextArea getAnswerArea()
    {
        return answerArea;
    }
}
