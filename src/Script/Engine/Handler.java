package Script.Engine;

import MainFrame.CustomComponents.CustomJLabel;
import Static.Colors;
import Static.Fonts;

import java.awt.*;
import java.util.ArrayList;

public class Handler
{
    private final int LINE_LIMIT = 300;

    private ArrayList<Token> tokenList;

    private ArrayList<String> columnStrings;

    private double size;

    private String data;
    private String cc;

    private CustomJLabel label;

    private boolean ATOM;
    private boolean LAST;

    private boolean CB;

    private int totalWrap;

    public Handler()
    {
        this.columnStrings = new ArrayList<>();
        this.tokenList = new ArrayList<>();

        this.label = new CustomJLabel();

        this.data = "";
        this.cc = "";

        this.totalWrap = 0;
        this.size = 0;

        this.ATOM = false;
        this.CB = false;
    }

    public void handle(String iterator, boolean LAST)
    {
        this.ATOM = true;
        this.LAST = LAST;

        this.handler(iterator, "</endl>");
        this.colorHandlers(iterator);
        this.fontHandlers(iterator);
        this.codeBlockHandler(iterator);

        //  Handlers is not optimized

        this.sizeHandlers(iterator);

        this.handler(iterator);
    }

    public void pretty()
    {
        ArrayList<Token> toDelete = new ArrayList<>();

        for(Token token : this.tokenList)
        {
            if(token.getData() == null)
            {
                toDelete.add(token);

            }
            else if(token.getData().getText().equals(""))
            {
                toDelete.add(token);
            }

            else {continue;}
        }
        this.tokenList.removeAll(toDelete);
    }

    public void load()
    {
        this.size = 0;

        for(int i = 0; i < this.tokenList.size(); i++)
        {
            if(i == this.tokenList.size() - 1)
            {
                this.tokenList.get(i).setCc("wrap");
                System.out.println("LOADING FINISHED");
            }
            else if(this.LINE_LIMIT < this.size)
            {
                this.tokenList.get(i - 1).setCc("wrap");
                this.size = 0;
                this.totalWrap++;
            }
            else
                {
                    this.size = this.size + (3.2 * this.tokenList.get(i).getData().getText().length());
                }

            if(this.tokenList.get(i).getCc().equals("wrap"))
            {
                this.size = 0;
            }
        }
    }

    public int getTotalWrap()
    {
        return this.totalWrap;
    }

    /******************************************************************************************************/

    private void tokenAdder(boolean cont, boolean endl)
    {
        this.ATOM = false;

        this.tokenList.add(new Token(this.label, this.cc));

        CustomJLabel label = this.label.getClone();

        this.label = new CustomJLabel();

        if(cont)
        {
            label.setText("");
            this.label = label;
        }
        if(cont && endl)
        {
            int p = (this.tokenList.size() < 2) ? 1 : 2;

            if(!(this.tokenList.get(this.tokenList.size() - p).getCc().equals("wrap")))
            {
                this.tokenList.get(this.tokenList.size() - p).addCC("wrap");
            }
            this.size = 0;
        }

        this.data = "";
        this.cc = "";
    }

    /******************************************************************************************************/

    private void handler(String iterator)
    {
        if(this.ATOM && !iterator.equals(""))
        {
            this.data = this.data + iterator + " ";
            this.label.setText(this.data);

            this.size = this.size + (3.2 * this.label.getText().length());

            if(this.LINE_LIMIT <= this.size)
            {
                System.out.println("t");
                this.tokenAdder(true, false);
                this.size = 0;
            }
            else if(this.LAST)
            {
                this.tokenAdder(false, false);
                this.size = 0;
            }

        } else { return; }
    }

    private void handler(String iterator, String str)
    {
        if (iterator.equals(str))
        {
            // END LINE HANDLER

            this.tokenAdder(true, true);
        }
        else{ return; }
    }

    private void handler(String iterator, String str, char cb)
    {
        if (iterator.equals(str))
        {
            // CODE BLOCK HANDLER

            this.tokenAdder(true, true);
            this.tokenList.get(tokenList.size() - 1).addCC("code");
            this.attrSetter(Colors.SECONDARY_COLOR, Font.SANS_SERIF, (Font.BOLD + Font.ITALIC), 20);
        }
        else{ return; }
    }

    private void handler(String iterator, String str, boolean close)
    {
        if(iterator.equals(str))
        {
            this.tokenAdder(false, false);
            this.attrReset();
        }
        else{ return; }
    }

    private void handler(String iterator, String str, boolean close, char cb)
    {
        if(iterator.equals(str))
        {
            this.tokenAdder(false, false);
            this.attrReset();
            this.tokenList.get(tokenList.size() - 1).setCc("code_end");
        }
        else{ return; }
    }

    private void handler(String iterator, String str, Color color)
    {
        if(iterator.equals(str))
        {
            this.tokenAdder(false, false);
            this.attrSetter(color);
        }
        else{ return; }
    }

    private void handler(String iterator, String str, int style)
    {
        if (iterator.equals(str))
        {
            this.tokenAdder(false, false);
            this.attrSetter(style);
        }
        else{ return; }
    }

    private void handler(String iterator, String str, Color color, String weight, int style, int size)
    {
        if(iterator.equals(str))
        {
            this.tokenAdder(false, false);
            this.attrSetter(color, weight, style, size);
        }
        else{ return; }
    }

    /******************************************************************************************************/

    private void attrReset()
    {
        this.label.setForeground(Colors.SECONDARY_COLOR);
        this.label.setFont(Fonts.NORMAL_FONT);
    }

    private void attrSetter(Color color)
    {
        this.attrReset();
        this.label.setForeground(color);
    }

    private void attrSetter(int style)
    {
        this.attrReset();
        this.label.setFont(new Font(Font.SANS_SERIF, style, 18));
    }

    private void attrSetter(Color color, String weight, int style, int size)
    {
        this.attrReset();
        this.label.setForeground(color);
        this.label.setFont(new Font(weight, style, size));
    }

    /******************************************************************************************************/

    public ArrayList<Token> getTokenList()
    {
        return tokenList;
    }

    public ArrayList<String> getColumnStrings()
    {
        return columnStrings;
    }

    public boolean getCB(){ return this.CB; };

    /******************************************************************************************************/

    private void codeBlockHandler(String iterator)
    {
        this.handler(iterator ,"<CodeBlock>", 'c');

        this.handler(iterator ,"</CodeBlock>", true, 'c');
    }

    private void colorHandlers(String iterator)
    {
        this.handler(iterator ,"<Blue>", Color.BLUE);
        this.handler(iterator ,"<Red>", Color.RED);
        this.handler(iterator ,"<Green>", Color.GREEN);

        this.handler(iterator ,"</Blue>", true);
        this.handler(iterator ,"</Red>", true);
        this.handler(iterator ,"</Green>", true);
    }

    private void sizeHandlers(String iterator)
    {
        for(int i = 15; i < 40; i++)
        {
            this.handler(iterator, String.format("<Font%d>", i), Colors.SECONDARY_COLOR, Font.SANS_SERIF, Font.BOLD, i);

            this.handler(iterator, String.format("<Font%d_Blue>", i), Color.BLUE, Font.SANS_SERIF, Font.BOLD, i);
            this.handler(iterator, String.format("<Font%d_Red>", i), Color.RED, Font.SANS_SERIF, Font.BOLD, i);
            this.handler(iterator, String.format("<Font%d_Green>", i), Color.GREEN, Font.SANS_SERIF, Font.BOLD, i);

            this.handler(iterator, String.format("<Font%d_Bold>", i), Colors.SECONDARY_COLOR, Font.SANS_SERIF, Font.BOLD, i);
            this.handler(iterator, String.format("<Font%d_Italic>", i), Colors.SECONDARY_COLOR, Font.SANS_SERIF,(Font.BOLD + Font.ITALIC), i);

            this.handler(iterator , String.format("</Font%d_Bold>", i), true);
            this.handler(iterator , String.format("</Font%d_Italic>", i), true);

            this.handler(iterator , String.format("</Font%d_Blue>", i), true);
            this.handler(iterator , String.format("</Font%d_Red>", i), true);
            this.handler(iterator , String.format("</Font%d_Green>", i), true);

            this.handler(iterator , String.format("</Font%d>", i), true);
        }
    }

    private void fontHandlers(String iterator)
    {
        this.handler(iterator, "<Italic>",Font.ITALIC);
        this.handler(iterator, "<Bold>",  Font.BOLD);

        this.handler(iterator, "</Italic>", true);
        this.handler(iterator, "</Bold>", true);
    }
}
