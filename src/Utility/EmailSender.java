package Utility;
import com.email.durgesh.Email;

public class EmailSender {
        String code;
        public EmailSender(String code, String mail) {
            this.code = code;
            try {
                Email email = new Email("bilforum102@gmail.com", "BilForumGF102*");
                email.setFrom("bilforum102@gmail.com", "BilForum");
                email.setSubject(code);
                email.setContent("<h1>" + code + "</h1>", "text/html");
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
