package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Piste {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nomPiste;
        private Couleurs couleur;
        private int longueur;
        private int pente;
        @ManyToMany(mappedBy = "pistes")
        List<Skieur> skieurs ;


}

