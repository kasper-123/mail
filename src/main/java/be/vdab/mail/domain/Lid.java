package be.vdab.mail.domain;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.*;
import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="leden")
public class Lid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @NotBlank(message="May Not Be Blank")
    private String voornaam;

   @NotBlank
    private String familienaam;
    @NotNull
    @Email
    private String emailAdres;
    @DateTimeFormat(style = "S-")
    private LocalDate lidSinds;
    protected Lid(){}

    public Lid(String voornaam, String familienaam, String emailAdres) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailAdres = emailAdres;
        this.lidSinds = LocalDate.now();

    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public LocalDate getLidSinds() {
        return lidSinds;
    }
}
