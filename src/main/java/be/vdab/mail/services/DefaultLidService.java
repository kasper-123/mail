package be.vdab.mail.services;

import be.vdab.mail.domain.Lid;
import be.vdab.mail.mailing.LidMailing;
import be.vdab.mail.repository.LidRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
public class DefaultLidService implements LidService{
    private final LidRepository lidRepository;
    private final LidMailing lidMailing;

    public DefaultLidService(LidRepository lidRepository, LidMailing lidMailing) {
        this.lidRepository = lidRepository;
        this.lidMailing = lidMailing;
    }

    @Override
    public void registreer(Lid lid, String ledenUrl) {lidRepository.save(lid);
        lidMailing.StuurMailNaRegistratie(lid,ledenUrl);
    }

    @Override

    public Optional<Lid> findById(long id) {
        return lidRepository.findById(id);
    }
}
