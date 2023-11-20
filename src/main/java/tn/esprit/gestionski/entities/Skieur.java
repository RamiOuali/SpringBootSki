package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long numSkieur;
    private String noms;
    private String prenoms;
    private LocalDate dateNaissance;
    private String ville;
    @OneToOne
    private  Abonnement abonnement ;
    @ManyToMany
    @JsonIgnore
    private List<Piste> pistes ;


    @OneToMany(mappedBy = "skieurs" ,cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Inscription> inscriptions;



}
