package tn.esprit.gestionski.Services;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class SkieurServiceImp implements ISkieur{
@Autowired
    SkieurRepository skieurRepository ;
    @Autowired
    PisteRepository pisteRepository;
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    InscriptionRepository inscriptionRepository;
    @Override
    public Skieur addSkieur(Skieur E) {
        return skieurRepository.save(E);
    }

    @Override
    public Skieur updateSkieur(Skieur E) {
        return skieurRepository.save(E);
    }

    @Override
    public List<Skieur> findAllSkieur() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur findByIdSkieur(long idS) {
        return skieurRepository.findById(idS).orElse(null);
    }

    @Override
    public void deleteFoyer(long idS) {
        skieurRepository.deleteById(idS);

    }

    @Override
    public void addInscriptionToSkieur(Inscription inscir, long numskieur) {

    }


    public Skieur assignSkieurToPiste(long numSkieur, long numPiste) {
        Skieur skieur =skieurRepository.findById(numSkieur).orElse(null) ;
        Piste piste=pisteRepository.findById(numPiste).orElse(null);
            skieur.getPistes().add(piste);
        return skieurRepository.save(skieur);

    }

    @Override
    public Skieur addSkieurandAssigntoCours(Skieur skieur, long numCours) {
        Skieur Savedskieur = skieurRepository.save(skieur);
        Cours cours= coursRepository.findById(numCours).orElse(null);
        List<Inscription> inscriptionsList= Savedskieur.getInscriptions();
        for(Inscription i:inscriptionsList){
            i.setSkieurs(Savedskieur);
            i.setCours(cours);
            inscriptionRepository.save(i);
        }
        return skieurRepository.save(skieur);

    }
    public List<Skieur> retreiverSkieurbySubscriptionType(TypeAbonnement type){
        return  skieurRepository.findByAbonnement_TypeAbon(type);

    }
  //  @Scheduled(fixedRate = 2000)
    @Scheduled (cron = "0 0 0 ")
    public void fixedRate(){
        log.info("methode with fixed rate");

    }

}