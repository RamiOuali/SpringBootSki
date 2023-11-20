package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numInscription;
    private int numSemaine;
    @ManyToOne
    @JsonIgnore
    private Cours cours;

    @ManyToOne
    @JsonIgnore
    private Skieur skieurs;
    }
