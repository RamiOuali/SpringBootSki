package tn.esprit.gestionski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;
@Service
 public class PisteServiceImp implements IPiste{
    SkieurRepository skieurRepository ;
    PisteRepository pisteRepository;
    @Override
    public Piste addCours(Piste c) {
        return null;
    }

    @Override
    public Piste updateCours(Piste c) {
        return null;
    }

    @Override
    public List<Piste> findAllPiste() {
        return null;
    }

    @Override
    public Piste findById(long numPiste) {
        return null;
    }

    @Override
    public void deletePiste(long numPiste) {

    }

    //
    @Override
    public Skieur AssignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        skieur.getPistes().add(piste);
        piste.getSkieurs().add(skieur);
        // skieur.getPisteSet().add(piste);
        skieurRepository.save(skieur);
        pisteRepository.save(piste);

        return skieur;

    }
}
