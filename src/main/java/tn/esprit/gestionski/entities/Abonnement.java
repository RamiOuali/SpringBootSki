package tn.esprit.gestionski.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long numAbon;
    private Date dateDebut;
    private Date dateFin;
    private float prixAbon;
@Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;

}
