package tn.esprit.gestionski.Services;

import

        org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
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
            throw new IllegalArgumentException("Le skieur doit avoir au moins 18 ans pour s'inscrire à ce cours adulte.");
        }
        inscription.setCours(cour);
        inscription.setSkieurs(skieur);

        return inscriptionRepository.save(inscription);
    }

    public List<Integer> numWeeksCourseOfInstructorBySupport(long numMoniteur, Support support){

        return  inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }
}
 /*On désire ajouter une inscription et l’affecter à un skieur et à un cours donnés.

▪ Créer le service adéquat et exposer le en respectant la signature suivante :

P a r t i e 5 S e r v i c e s a v a n c é s

Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription,

Long numSkieur, Long numCours);

▪ N.B : L’inscription à un cours donné ne doit pas dépassé 6 Skieurs/Cours si le type de
cours est Collectif (COLLECTIF_ENFANT ou COLLECTIF_ADULTE).

▪ L'âge de Skieur est encore vérifié au moment de l’affectation.*/
