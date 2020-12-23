package Utility;

public class Utility
{
    public static boolean checkEmail(String email)
    {
        String bilMail = email.substring(email.indexOf("@"));

        return (bilMail.equals("@ug.bilkent.edu.tr")) ? false : true;
    }
}
