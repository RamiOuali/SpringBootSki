package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numC;
    private int niveau ;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.STRING)
    private Support support;
    private Float prix;
    private int creneau;
@ManyToOne
private Moniteur moniteur;

    @OneToMany(mappedBy = "cours")
    @JsonBackReference
    private List<Inscription> inscriptions;

}
