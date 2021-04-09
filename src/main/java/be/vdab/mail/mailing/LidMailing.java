package be.vdab.mail.mailing;

import be.vdab.mail.domain.Lid;

public interface LidMailing {
    void StuurMailNaRegistratie(Lid lid, String ledenURL);
}
