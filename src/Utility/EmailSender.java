package Utility;
import com.email.durgesh.Email;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import java.util.Collections;

public class EmailSender
{
    private String code;

    public EmailSender(String code, String mail)
    {
        this.code = code;

        sendEmail(mail);
    }

    private void sendEmail(String mail)
    {
        try
        {
            Email email = new Email("bilforum102@gmail.com", "BilForumGF102*");
            email.setFrom("bilforum102@gmail.com", "BilForum");
            email.setSubject(code);
            email.setContent(String.format("<div><h1>%s</h1></div>", this.code), "text/html");
            email.addRecipient(mail);
            email.send();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public String getCode()
    {
        return this.code;
    }


    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender("1212", "ecanikli20@gmaiffdsfl");
        System.out.println("SECOND");
    }
}
