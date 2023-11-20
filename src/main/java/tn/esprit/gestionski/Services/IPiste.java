package tn.esprit.gestionski.Services;

import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface IPiste {

    public Piste addCours(Piste c);

    public Piste updateCours(Piste c);

    public List<Piste> findAllPiste();

    public Piste findById(long  numPiste);

    public void deletePiste(long numPiste);

    public Skieur AssignSkieurToPiste(Long numskieur, Long numPiste);
}
