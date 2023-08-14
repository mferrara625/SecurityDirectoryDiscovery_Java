import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class EmailSender {
    public static void sendMessage(String email, String password) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        Session sess = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email,password);
                    }
                });
        try{
            MimeMessage msg = new MimeMessage(sess);
            msg.setFrom(new InternetAddress(email));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            msg.setSubject("Welcome To My Domain");
            BodyPart mbody = new MimeBodyPart();
            mbody.setText("Your Message body is sent");
            MimeBodyPart mbody1 = new MimeBodyPart();
            String filename = "C:/Users/Mike/Documents/windowsDirectory.txt";
            DataSource source = new FileDataSource(filename);
            mbody1.setDataHandler(new DataHandler(source));
            mbody1.setFileName(filename);
            Multipart mpart = new MimeMultipart();
            mpart.addBodyPart(mbody);
            mpart.addBodyPart(mbody1);
            msg.setContent(mpart );
            Transport.send(msg);
            System.out.println("Your email is sent successfully");
        }catch (MessagingException ex) {ex.printStackTrace();}
    }
}
