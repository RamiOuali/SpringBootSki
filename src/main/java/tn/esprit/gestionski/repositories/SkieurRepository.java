package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public  interface SkieurRepository extends JpaRepository<Skieur,Long>{

    public List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement type);

    // triel set  get su



}