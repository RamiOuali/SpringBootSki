package tn.esprit.gestionski.Services;

import tn.esprit.gestionski.entities.Moniteur;

public interface IMoniteur {
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur,long numcours);
}
