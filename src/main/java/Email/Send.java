package Email;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by was12 on 20/03/2017.
 */
public class Send {
    public void send(String toAddr,String subject,String body){
        // Spring Bean file you specified in /src/main/resources folder
        String crunchifyConfFile = "settings.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
        Email EmailAPI = (Email) context.getBean("Email");
        String fromAddr = "vetmanagerApp@gmail.com";
        EmailAPI.ReadyToSendEmail(toAddr, fromAddr, subject, body);
    }
}
