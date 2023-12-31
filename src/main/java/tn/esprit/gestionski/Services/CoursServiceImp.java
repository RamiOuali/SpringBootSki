package tn.esprit.gestionski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.repositories.CoursRepository;

import java.util.List;

@Service

public class CoursServiceImp implements ICours {
    @Autowired
    private CoursRepository courRepository;

    @Override
    public Cours addCours(Cours c) {
        return courRepository.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return courRepository.save(c);
    }

    @Override
    public List<Cours> findAllCours() {
        return courRepository.findAll();
    }

    @Override
    public Cours findById(long numCours) {
        return courRepository.findById(numCours).orElse(null);
    }

    @Override
    public void deleteCours(long numCours) {
        courRepository.deleteById(numCours);
    }



}