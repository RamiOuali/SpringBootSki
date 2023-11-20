package tn.esprit.gestionski.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomM;
    private String prenomM;
    private Date dateRecru;
    @OneToMany
    List<Cours> cours ;



}

