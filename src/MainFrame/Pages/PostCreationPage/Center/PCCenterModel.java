package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.CustomJTextField;
import MainFrame.MainFrameModel;
import PojoClasses.Post;
import Static.Colors;
import Static.ConstantText;
import Static.Fonts;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PCCenterModel implements IPCCenterModel
{
    private SizeConstants sc;

    private IPCCenterView postCreationCenterView;

    /*******************************************************************************************/

    private CustomJTextField titleField;

    private JTextPane syntaxInfo;
    private JTextArea contentInput;

    private JPanel scrollPanel;
    private JScrollPane sp;

    private JPanel  lowerPanel;
    private JButton postBtn;

    private CustomJPanel panel1;
    private CustomJPanel panel2;

    private CustomJLabel tagsLabel;
    private CustomJTextField tagsTextField;

    /*******************************************************************************************/

    private String syntaxInfoText = ConstantText.getPostCreationPageSyntax();

    /*******************************************************************************************/

    private JPanel titlePanel;
    private JPanel middlePanel;
    private JPanel guidePanel;

    private JLabel titleLabel;
    private JLabel contentLabel;

    private static MainFrameModel mainFrameModelReference;

    private Post post;

    public PCCenterModel(MainFrameModel ref)
    {
        this.mainFrameModelReference = ref;
        this.sc = new SizeConstants();

        this.init();
    }

    private void init()
    {
        this.initFields();
    }

    private void initFields()
    {
        this.titlePanel = new CustomJPanel();
        this.titlePanel.setOpaque(false);

        this.titleField = new CustomJTextField(5);
        this.titleField.setFont(Fonts.TITLE_FONT);

        this.titleLabel = new CustomJLabel();
        this.titleLabel.setText("Title:");
        this.titleLabel.setFont(Fonts.TITLE_FONT);

        /**************************************************************/

        this.middlePanel = new CustomJPanel();

        this.contentLabel = new CustomJLabel();
        this.contentLabel.setText("Content:");
        this.contentLabel.setFont(Fonts.TITLE_FONT);

        this.syntaxInfo = new JTextPane();
        this.syntaxInfo.setOpaque(false);
        this.syntaxInfo.setEditable(false);
        this.syntaxInfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        this.syntaxInfo.setForeground(Colors.SECONDARY_COLOR);
        this.syntaxInfo.setText(this.syntaxInfoText);

        this.scrollPanel = new CustomJPanel();

        this.sp = new JScrollPane();
        this.sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.sp.setBorder(BorderFactory.createEmptyBorder());

        this.contentInput = new JTextArea();
        this.contentInput.setOpaque(true);
        this.contentInput.setBackground(Colors.MAIN_COLOR);
        this.contentInput.setWrapStyleWord(true);
        this.contentInput.setLineWrap(true);
        this.contentInput.setFont(Fonts.NORMAL_FONT);
        this.contentInput.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        /*************************************************************/

        this.lowerPanel = new CustomJPanel();

        this.postBtn = new CustomJButton();
        this.postBtn.setText("Post");

        this.panel1 = new CustomJPanel();
        this.panel2 = new CustomJPanel();

        this.tagsTextField = new CustomJTextField(5);
        this.tagsTextField.setText("#Hello_World");
        this.tagsTextField.setForeground(Colors.SECONDARY_COLOR);

        this.tagsLabel = new CustomJLabel();
        this.tagsLabel.setText("Tags:");
        this.tagsLabel.setFont(Fonts.TITLE_FONT);

        /***************************************************************/

        this.guidePanel = new CustomJPanel();

        this.postBtn.setName("POST");
    }

    /*******************************************************************************************/

    public void changeToEditMode(Post post)
    {
        this.titleField.setText(post.getTitle());
        this.contentInput.setText(post.getContent());
        this.tagsTextField.setText(post.getTags().replace(',', '#'));
        this.postBtn.setName("UPDATE");
        this.postBtn.setText("Update");
        this.post = post;
    }

    public void changeToPostMode()
    {
        this.postBtn.setName("POST");
        this.postBtn.setText("Post");
    }

    /*******************************************************************************************/

    @Override
    public CustomJPanel getView()
    {
        this.update();
        return (CustomJPanel) this.postCreationCenterView;
    }

    @Override
    public void setView(IPCCenterView view)
    {
        this.postCreationCenterView = view;
    }

    @Override
    public void update()
    {
        this.postCreationCenterView.update(this);
    }

    /*******************************************************************************************/

    public void addActionListenerToPostBtn(ActionListener AL)
    {
        this.postBtn.addActionListener(AL);
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return sc;
    }

    public JTextField getTitleField()
    {
        return titleField;
    }

    public JTextPane getSyntaxInfo()
    {
        return syntaxInfo;
    }

    public JTextArea getContentInput()
    {
        return contentInput;
    }

    public JPanel getScrollPanel()
    {
        return scrollPanel;
    }

    public JScrollPane getSp()
    {
        return sp;
    }

    public JPanel getLowerPanel()
    {
        return lowerPanel;
    }

    public JButton getPostBtn()
    {
        return postBtn;
    }

    public JPanel getPanel1()
    {
        return panel1;
    }

    public CustomJTextField getTagsTextField()
    {
        return tagsTextField;
    }

    public CustomJLabel getTagsLabel()
    {
        return this.tagsLabel;
    }

    public CustomJPanel getPanel2()
    {
        return this.panel2;
    }

    /****************************/

    public String getSyntaxInfoText() {
        return syntaxInfoText;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public JLabel getContentLabel()
    {
        return this.contentLabel;
    }

    public JPanel getGuidePanel()
    {
        return this.guidePanel;
    }

    public static MainFrameModel getRef()
    {
        return mainFrameModelReference;
    }

    public Post getPost()
    {
        return post;
    }
}

