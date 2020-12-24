package Script.Engine;

import javax.swing.*;
import java.awt.*;

public class Token
{
    private JLabel data;

    private String cc;

    private Color color;
    private Font font;

    public Token(JLabel data, String cc)
    {
        this.data = data;
        this.cc = cc;

        this.color = null;
        this.font = null;
    }

    public JLabel getData()
    {
        return data;
    }

    public void setData(JLabel data)
    {
        this.data = data;
    }

    public String getCc()
    {
        return cc;
    }

    public void setCc(String cc)
    {
        this.cc = cc;
    }

    public void addCC(String data)
    {
        if(this.cc.length() != 0)
        {
            this.cc = this.cc + "," +data;
        }
        else {this.cc = this.cc + data; }
    }
}
