package Utility;
import com.email.durgesh.Email;

public class EmailSender {
    public static void main(String[] args) {
        String code = "42323";

        try{
            Email email = new Email("bilforum102@gmail.com", "BilForumGF102*");
            email.setFrom("bilforum102@gmail.com", "BilForum");
            email.setSubject(code);
            email.setContent("<h1>deneme</h1>", "text/html");
            email.addRecipient("ecanikli20@gmail.com");
            email.send();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
