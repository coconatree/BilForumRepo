package Utility;

import javax.swing.*;

public class PopUp
{
    private String message;

    public PopUp ( String message )
    {
        this.message = message ;
        JOptionPane.showMessageDialog( null, message ,"Error!", JOptionPane.INFORMATION_MESSAGE);
    }
}
