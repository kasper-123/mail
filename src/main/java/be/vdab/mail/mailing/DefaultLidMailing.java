package be.vdab.mail.mailing;

import be.vdab.mail.domain.Lid;
import be.vdab.mail.exceptions.KanMailNietVerzendenException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
class DefaultLidMailing  implements LidMailing{
    private final JavaMailSender sender;

    DefaultLidMailing(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void StuurMailNaRegistratie(Lid lid, String ledenURL) {
        try{var message = new SimpleMailMessage();
            message.setTo(lid.getEmailAdres());
            message.setSubject("Geregistreerd");
            message.setText("Je bent nu lid.Jenummeris:" + lid.getId());sender.send(message);}
        catch(MailException ex) {throw new KanMailNietVerzendenException(ex);}
    }
}
