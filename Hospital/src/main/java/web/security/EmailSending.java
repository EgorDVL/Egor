package web.security;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Egor on 13.11.2016.
 */
public class EmailSending {
    public static void sendMailMessange(String mailTo, String password) throws AddressException, MessagingException {

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("ZhyzhkoYehor@gmail.com", "Q1wER1994Egor");//change accordingly
                    }
                });

        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ZhyzhkoYehor@gmail.com"));//change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            message.setSubject("Hello dear User");
            message.setText(" Welcome in our hospital." + " Thanks for registring. "
                    + "This is your Login: " + mailTo + ". This is your Password: " + password + ". Have a good day");

            //send message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}