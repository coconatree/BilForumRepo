package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.CustomJTextField;
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

    private JPanel panel1;
    private CustomJTextField tagsTextField;

    /*******************************************************************************************/

    private String syntaxInfoText = ConstantText.getPostCreationPageSyntax();

    /*******************************************************************************************/

    public PCCenterModel()
    {
        this.sc = new SizeConstants();

        this.init();
    }

    private void init()
    {
        this.initFields();
    }

    private void initFields()
    {
        this.titleField = new CustomJTextField(5);
        this.titleField.setFont(Fonts.TITLE_FONT);

        this.syntaxInfo = new JTextPane();
        this.syntaxInfo.setOpaque(false);
        this.syntaxInfo.setEditable(false);
        this.syntaxInfo.setText(this.syntaxInfoText);

        this.scrollPanel = new CustomJPanel();

        this.sp = new JScrollPane();
        this.sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.sp.setBorder(BorderFactory.createEmptyBorder());

        this.contentInput = new JTextArea();
        this.contentInput.setOpaque(true);
        this.contentInput.setBackground(Colors.MAIN_BACKGROUND_COLOR);
        this.contentInput.setWrapStyleWord(true);
        this.contentInput.setLineWrap(true);
        this.contentInput.setFont(Fonts.NORMAL_FONT);
        this.contentInput.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        this.lowerPanel = new CustomJPanel();

        this.postBtn = new CustomJButton();
        this.postBtn.setText("POST");

        this.panel1 = new CustomJPanel();

        this.tagsTextField = new CustomJTextField(5);
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
}
