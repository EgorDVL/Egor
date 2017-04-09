package zhyzhko.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import zhyzhko.spring.demo.dto.UserDto;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Egor on 29.03.2017.
 */
@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(UserDto userDto) {
        MimeMessagePreparator preparator = getMessagePreparator(userDto);
        try {
            mailSender.send(preparator);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(UserDto userDto) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("ZhyzhkoYehor@gmail.com");

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(userDto.getEmail()));
                mimeMessage.setText("Dear " + userDto.getName()
                        + ", thank you for registration. Your password is " + userDto.getPassword() + ".");
                mimeMessage.setSubject("Your user app");
            }
        };
        return preparator;
    }
}
