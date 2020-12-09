package MainFrame.Pages.PostCreationPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PCCenterModel implements IPCCenterModel
{
    private SizeConstants sc;

    private IPCCenterView postCreationCenterView;

    /*******************************************************************************************/

    private JTextField titleField;

    private JTextPane syntaxInfo;
    private JTextPane contentInput;

    private JPanel scrollPanel;
    private JScrollPane sp;

    private JPanel  lowerPanel;
    private JButton postBtn;

    /*******************************************************************************************/

    private String syntaxInfoText = "AAAAAAAAAAAAAAAAAAAAAAAAA";

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
        this.titleField = new JTextField(5);

        this.syntaxInfo = new JTextPane();
        this.syntaxInfo.setOpaque(false);
        this.syntaxInfo.setEditable(false);
        this.syntaxInfo.setText(this.syntaxInfoText);

        this.scrollPanel = new CustomJPanel();

        this.sp = new JScrollPane();

        this.sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.contentInput = new JTextPane();
        this.contentInput.setOpaque(true);

        this.lowerPanel = new CustomJPanel();

        this.postBtn = new JButton();
        this.postBtn.setText("POST");
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

    public JTextPane getContentInput()
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
}
