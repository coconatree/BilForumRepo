package Script.ViewComponent;

import MainFrame.CustomComponents.CustomJPanel;
import Script.Engine.Handler;
import Script.Engine.Lexer;
import Script.Engine.Token;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SyntaxComponentModel
{
    private ArrayList<String> dataList;
    private ArrayList<Token> tokenList;

    private ArrayList<String> layoutStrings;

    private String data;

    private Handler handler;

    private JPanel panel;

    private SyntaxComponentView view;

    public SyntaxComponentModel(String data)
    {
        this.data = data;
        this.init();
    }

    private void init()
    {
        Lexer lexer = new Lexer();

        this.panel = new CustomJPanel();

        this.dataList = lexer.parseList(this.data);

        this.tokenizer();

        this.tokenList = this.handler.getTokenList();

        this.layoutStrings = this.handler.getColumnStrings();
    }

    /*********************************************************************************************************/

    public void setView(SyntaxComponentView view)
    {
        this.view = view;
    }

    public SyntaxComponentView getView()
    {
        this.update(this);
        return this.view;
    }

    public void update(SyntaxComponentModel model)
    {
        this.view.update(model);
    }

    /*********************************************************************************************************/

    public void resetPanel(boolean code)
    {
        this.panel = new CustomJPanel();

        if(code)
        {
            this.panel.setBackground(Color.LIGHT_GRAY);
        }
    }

    /*********************************************************************************************************/

    private void tokenizer()
    {
        this.handler = new Handler();

        for (String iterator : this.dataList)
        {
            if(iterator.equals(this.dataList.get(this.dataList.size() - 1)))
            {
                handler.handle(iterator, true);
            }
            else { handler.handle(iterator, false);}
        }

        handler.pretty();
        handler.load();
    }

    /*********************************************************************************************************/

    public String getRowCC(int tot)
    {
        String cc = "";

        for (int i = 0; i < tot; i++)
        {
            if (i == 0)
            {
                cc = cc + "[20]";
            }
            else { cc = cc + "5[20]"; }
        }
        return cc;
    }

    /*********************************************************************************************************/

    public int getTotalWrap()
    {
        return this.handler.getTotalWrap();
    }

    public ArrayList<String> getDataList() {
        return dataList;
    }

    public ArrayList<String> getLayoutList() {
        return layoutStrings;
    }

    public ArrayList<Token> getTokenList() {
        return tokenList;
    }

    public JPanel getPanel() {
        return panel;
    }
}
