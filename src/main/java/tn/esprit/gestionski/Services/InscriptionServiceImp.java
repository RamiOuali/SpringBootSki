package tn.esprit.gestionski.Services;

import lombok.extern.slf4j.Slf4j;
import

        org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class InscriptionServiceImp implements IInscription {
    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
    CoursServiceImp coursServiceImp;

    @Override
    public Inscription addInscription(Inscription E) {
        return inscriptionRepository.save(E);
    }

    @Override
    public Inscription updateInscription(Inscription E) {
        return inscriptionRepository.save(E);
    }

    @Override
    public List<Inscription> findAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription findByIdInscription(long idI) {
        return inscriptionRepository.findById(idI).orElse(null);
    }

    @Override
    public void deleteInscription(long idI) {
        inscriptionRepository.deleteById(idI);

    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscir, long numSkieur) {
        Skieur skieur = skieurRepository.getById(numSkieur);
        inscir.setSkieurs(skieur);
        return inscriptionRepository.save(inscir);


    }

    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, long numcours) {

        Cours cour = coursServiceImp.findById(numcours);
        inscription.setCours(cour);
        return inscriptionRepository.save(inscription);
    }

    public Inscription addInscpriptionAndAssingToCoursAndSkieur(Inscription inscription, long numSkieur, long NumCours) {
        Cours cour = coursServiceImp.findById(NumCours);
        Skieur skieur = skieurRepository.getById(numSkieur);

        if (cour.getTypeCours().equals(TypeCours.COLLECTIF_ENFANT) && cour.getInscriptions().size() >= 6) {
            throw new IllegalArgumentException(" plus que 6 inscriptions pour cours.");
        } else if (cour.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE) && cour.getInscriptions().size() >= 6) {
            throw new IllegalArgumentException(" que 6 inscriptions pour ce cours.");
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = skieur.getDateNaissance();
        int age = Period.between(birthDate, currentDate).getYears();

        if (cour.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE) && age < 18) {
            throw new IllegalArgumentException(" 18 ans pour  ce cours ");
        }
        inscription.setCours(cour);
        inscription.setSkieurs(skieur);

        return inscriptionRepository.save(inscription);
    }

    public List<Integer> numWeeksCourseOfInstructorBySupport(long numMoniteur, Support support){

        return  inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }





}
