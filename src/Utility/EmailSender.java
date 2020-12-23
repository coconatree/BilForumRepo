package Utility;
import AuthFrame.AuthFrameModel;
import com.email.durgesh.Email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmailSender {
    String code;

    public static void main(String[] args) {
        try
        {
            EmailSender sender = new EmailSender("121212", "ecanikli20@gmail.com");
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }

    public EmailSender(String code, String mail) throws MessagingException {
        this.code = code;
        String fileFinder;
        String fileFinder2 = "";
        Multipart multipart = new MimeMultipart();
        URL url = AuthFrameModel.class.getResource("/AUTH_LOGO.png");
        fileFinder = url.toString().substring(6);
        System.out.println(fileFinder);
        for(int i = 0; i< fileFinder.length(); i++)
        {
            if(fileFinder.charAt(i) == '/')
            {
                fileFinder2 += '\\';
            }
            else
            {
                fileFinder2 += "" + fileFinder.charAt(i);
            }
        }
        Path p = Paths.get(fileFinder2);
        System.out.println("C:\\Users\\MSI\\Desktop\\old\\BilForumRepo\\logo.png");
        System.out.println(fileFinder2);
        //String file = p.getFileName().toString();

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        BodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent("<h2>" +" your code: "+ code + "</h2>" , "text/html");

        DataSource source = new FileDataSource(fileFinder2);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("BILFORUM");
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(htmlBodyPart);

        try {

            Email email = new Email("bilforum102@gmail.com", "BilForumGF102*");
            email.setFrom("bilforum102@gmail.com", "BilForum");
            email.setSubject(code);
            email.addAttatchment(multipart);
            email.addRecipient(mail);
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getCode()
    {
        return this.code;
    }

}
