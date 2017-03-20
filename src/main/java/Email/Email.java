package Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by was12 on 20/03/2017.
 */
@Service("Email")
public class Email {

    @Autowired
    private MailSender mail; // MailSender interface defines a strategy
    // for sending simple mails

    public synchronized void ReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

        SimpleMailMessage Msg = new SimpleMailMessage();
        Msg.setFrom(fromAddress);
        Msg.setTo(toAddress);
        Msg.setSubject(subject);
        Msg.setText(msgBody);
        mail.send(Msg);
    }

}
