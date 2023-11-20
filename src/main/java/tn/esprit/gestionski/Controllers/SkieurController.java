package tn.esprit.gestionski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.Services.ISkieur;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@AllArgsConstructor
public class SkieurController {
    private ISkieur skieurService ;


    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur E ){
        return skieurService.addSkieur(E);

    }
    @PutMapping("/updateSkieur")
    public Skieur updateEtudiant(@RequestBody Skieur E ){
        return skieurService.updateSkieur(E);

    }
    @GetMapping("/getAllSkieur")
    public List<Skieur> getAllEtudiant(){
        return skieurService.findAllSkieur();

    } @GetMapping("/GetSkieurid/{idf}")
    public Skieur GetEtudaiantbyid(@PathVariable long idE ){
        return skieurService.findByIdSkieur(idE);

    }
    @PostMapping("/addInscr")
    public void addInsprcitonandassingtoSkieur(@RequestBody Inscription E ,long Num ){
        skieurService.addInscriptionToSkieur( E,Num);

    }
    @PostMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable long numSkieur, @PathVariable long numPiste) {
        return skieurService.assignSkieurToPiste(numSkieur, numPiste);
    }
    @PostMapping("/AddkieurAndAssginToCours/{numCours}")
    public Skieur AddkieurAndAssginToCours(@RequestBody Skieur skieur, @PathVariable long numCours) {
        return skieurService.addSkieurandAssigntoCours(skieur,numCours);
    }

 @GetMapping("/GetSkieurByAbon/{type}")
public List<Skieur> GetEtudaiantbyid(@PathVariable TypeAbonnement type){
    return skieurService.retreiverSkieurbySubscriptionType(type);

}

}





