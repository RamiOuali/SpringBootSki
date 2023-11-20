package tn.esprit.gestionski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.gestionski.Services.IInscription;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

@RestController

@AllArgsConstructor
public class InscriptionController

{
    private IInscription inscriptionService;

    @PostMapping("/addInscription")
    public void addInscription(@RequestBody Inscription inscription)

    {
        inscriptionService.addInscription(inscription);
    }
    @GetMapping("/getAllInscription")
    public List<Inscription> getAllInspcription(){
        return inscriptionService.findAllInscription();
    }
    @PostMapping("/addInscriptionToSkieur/{numSkieur}")
    public void addInscriptiontoSkieur(@RequestBody Inscription inscription, @PathVariable Long numSkieur) {
        inscriptionService.addInscriptionAndAssignToSkieur(inscription, numSkieur);
    }

    @PostMapping("/addInscriptionToSkieurandCours/{numSkieur}/{numCours}")
    public void addInscriptiontoSkieur2(@RequestBody Inscription inscription, @PathVariable long numSkieur, @PathVariable  long numCours) {
        inscriptionService.addInscpriptionAndAssingToCoursAndSkieur(inscription, numSkieur,numCours);
    }

    @GetMapping("/numWeeksCours/{numMoniteur}/{support}")
    public List<Integer>  numWeeksCours(@PathVariable long numMoniteur, @PathVariable Support support) {
   return      inscriptionService.numWeeksCourseOfInstructorBySupport(numMoniteur, support);

    }



}