package tn.esprit.gestionski.Services;

import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface IInscription {
    public Inscription addInscription(Inscription E);

    public Inscription updateInscription(Inscription E);

    public List<Inscription> findAllInscription();
    public Inscription findByIdInscription(long idI);
    public void deleteInscription(long idI);

    public Inscription addInscriptionAndAssignToSkieur(Inscription inscir, long numskieur);
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, long numcours);
    public Inscription addInscpriptionAndAssingToCoursAndSkieur(Inscription inscription, long NumCours, long numSkieur) ;

    List<Integer> numWeeksCourseOfInstructorBySupport(long numMoniteur, Support support);
}