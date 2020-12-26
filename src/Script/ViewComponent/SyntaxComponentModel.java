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
        this.init(data);
    }

    private boolean empty;

    public SyntaxComponentModel(boolean empty)
    {
        this.empty = empty;
        this.data = null;

        this.handler = new Handler();
    }

    public void init(String data)
    {
        this.empty = false;
        this.data = data;

        this.handler = new Handler();

        Lexer lexer = new Lexer();

        System.out.println("DATA : " + this.data);

        this.panel = new CustomJPanel();

        this.dataList = lexer.parseList(this.data);

        this.tokenizer();

        this.tokenList = this.handler.getTokenList();

        this.layoutStrings = this.handler.getColumnStrings();
    }

    /*********************************************************************************************************/

    public void setView(SyntaxComponentView view)
    {
        System.out.println("VIEW SET");
        this.view = view;
        this.update();
    }

    public SyntaxComponentView getView()
    {
        if(this.view == null)
        {
            SyntaxComponentView view1 = new SyntaxComponentView();
            view1.update(true);
            return view1;
        }
        else
            {
                this.update();
                return this.view;
            }
    }

    public void update()
    {
        this.view.update(this);
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

    public void setData(String data)
    {
         this.data = data;
    }
}
