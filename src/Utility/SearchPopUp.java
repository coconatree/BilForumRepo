package Utility;

import MainFrame.CustomComponents.CustomJButton;
import MainFrame.CustomComponents.CustomJLabel;
import MainFrame.CustomComponents.CustomJPanel;
import PojoClasses.Post;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPopUp extends JOptionPane
{
    private ArrayList<Post> postList;

    private JPanel panel;

    private JLabel label;

    public SearchPopUp ( ArrayList<Post> list )
    {
        this.postList = list;
        this.panel = new CustomJPanel();



        MigLayout layout = new MigLayout("inset 5 5 5 5", "[grow]", this.stingGenerator(this.postList.size()));

        this.panel.setLayout(layout);

        for(Post post : this.postList)
        {
            this.label = new CustomJLabel();
            this.label.setText(String.format("Title: %s Inside: %s", post.getTitle(), post.getId().substring(0, post.getId().indexOf("P"))));
            this.panel.add(label, "grow, wrap");
        }

        this.postList = list;
        this.showMessageDialog( null, this.panel ,"Search Results", JOptionPane.INFORMATION_MESSAGE);
    }

    public String stingGenerator(int size)
    {
        String ret = "";

        for(int i = 0; i < size; i++)
        {
            if(i == 0){ ret += "[grow]"; }
            else{ ret += "5[grow]"; }
        }
        return ret;
    }
}
