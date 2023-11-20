package tn.esprit.gestionski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.Services.IMoniteur;
import tn.esprit.gestionski.entities.Moniteur;

@RestController
@AllArgsConstructor
public class MoniteurController {

    IMoniteur imoniteur;
   @PostMapping("/addMoniteurAndAssignToCours/{numcours}")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur moniteur,@PathVariable long numcours){
        return imoniteur.addMoniteurAndAssignToCours(moniteur,numcours);
    }
}
