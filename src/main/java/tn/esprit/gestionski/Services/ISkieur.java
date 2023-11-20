package tn.esprit.gestionski.Services;

import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public interface ISkieur {
    public Skieur addSkieur(Skieur E);

    public Skieur updateSkieur(Skieur E);

    public List<Skieur> findAllSkieur();
    public Skieur findByIdSkieur(long idS);
    public void deleteFoyer(long idS);

    public void addInscriptionToSkieur(Inscription inscir, long numskieur);
    public Skieur assignSkieurToPiste(long numSkieur, long numPiste);


    public Skieur addSkieurandAssigntoCours(Skieur skieur, long numCours);
    public List<Skieur> retreiverSkieurbySubscriptionType(TypeAbonnement type);


}


