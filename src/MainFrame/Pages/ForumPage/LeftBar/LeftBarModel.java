package MainFrame.Pages.ForumPage.LeftBar;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.CustomComponents.CustomJTextPane;
import MainFrame.MainFrameModel;
import Static.ConstantText;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LeftBarModel implements ILeftBaModel
{
    private ILeftBarView LBV;
    private SizeConstants sc;

    /*******************************************************************************************/

    private JTextPane textPane;

    /*******************************************************************************************/

    private CustomJButton byViewButton;
    private CustomJButton byVoteButton;
    private CustomJButton addPostButton;

    /*******************************************************************************************/

    private String textPaneText;
    private String byViewButtonText;
    private String byVoteButtonText;
    private String addPostButtonText;

    /*******************************************************************************************/

    private CustomJPanel topPanel;
    private CustomJPanel bottomPanel;

    /*******************************************************************************************/

    private MainFrameModel mainFrameModelReference;


    public LeftBarModel(MainFrameModel ref)
    {
        this.mainFrameModelReference = ref;
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.textPaneText = ConstantText.getForumPageLeftText();
        this.byViewButtonText = "By View";
        this.byVoteButtonText = "By Vote";
        this.addPostButtonText = "Create a post";

        this.initButtons();
        this.initTextPane();
        this.initPanels();
    }

    private void initButtons()
    {
        this.byViewButton = new CustomJButton();
        this.byViewButton.setText(this.byViewButtonText);

        this.byVoteButton = new CustomJButton();
        this.byVoteButton.setText(this.byVoteButtonText);

        this.addPostButton = new CustomJButton();
        this.addPostButton.setText(this.addPostButtonText);
    }

    private void initTextPane()
    {
        this.textPane = new CustomJTextPane();
        this.textPane.setText(this.textPaneText);
        this.textPane.setOpaque(false);
    }

    private void initPanels()
    {
        this.topPanel = new CustomJPanel();
        this.bottomPanel = new CustomJPanel();
    }

    /*******************************************************************************************/

    @Override
    public void setView(ILeftBarView view)
    {
        this.LBV = view;
    }

    @Override
    public CustomJPanel getView()
    {
        this.LBV.update(this);
        return (CustomJPanel) this.LBV;
    }

    @Override
    public void update()
    {
        this.LBV.update(this);
    }

    /*******************************************************************************************/

    public void addActionListenerToByDateBtn(ActionListener AL)
    {
        this.byViewButton.addActionListener(AL);
    }

    public void addActionListenerToByVoteBtn(ActionListener AL)
    {
        this.byVoteButton.addActionListener(AL);
    }

    public void addActionListenerToAddPostBtn(ActionListener AL)
    {
        this.addPostButton.addActionListener(AL);
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return this.sc;
    }

    public JTextPane getTextPane()
    {
        return this.textPane;
    }

    public CustomJButton getByViewButton()
    {
        return this.byViewButton;
    }

    public CustomJButton getByVoteButton()
    {
        return this.byVoteButton;
    }

    public CustomJButton getAddPostButton()
    {
        return this.addPostButton;
    }

    public CustomJPanel getTopPanel()
    {
        return this.topPanel;
    }

    public CustomJPanel getBottomPanel()
    {
        return this.bottomPanel;
    }

    /*******************************************************************************************/

    public MainFrameModel getRef()
    {
        return this.mainFrameModelReference;
    }
}


