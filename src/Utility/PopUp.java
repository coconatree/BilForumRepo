package Utility;

import javax.swing.*;

public class PopUp
{
    private String message;

    public PopUp ( String message )
    {
        this.message = message ;
        JOptionPane.showMessageDialog( null, message ,"Message!", JOptionPane.INFORMATION_MESSAGE);
    }
}
