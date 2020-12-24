package Script.Engine;

import java.util.ArrayList;

public class Lexer
{
    private String element;
    private ArrayList<String> list;

    public ArrayList<String> parseList(String str)
    {
        this.list = new ArrayList<>();

        this.element = "";

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ' ')
            {
                list.add(element);
                element = "";
            }
            else if(str.charAt(i) == ',')
            {
                this.addToList(",");
            }
            else if(str.charAt(i) == ';')
            {
                this.addToList(";");
            }
            else if(str.charAt(i) == '.')
            {
                this.addToList(".");
            }
            else if(str.charAt(i) == '!')
            {
                this.addToList("!");
            }
            else if(str.charAt(i) == '?')
            {
                this.addToList("?");
            }
            else
                {
                    element += str.charAt(i);
                }
        }

        list.add(element);

        for(int i = 0; i < this.list.size(); i++)
        {
            if(list.get(i).equals(""))
            {
                list.remove(i);
            }
        }
        return list;
    }

    private void addToList(String extra)
    {
        this.list.add(element);
        this.list.add(extra);
        this.element = "";
    }
}
