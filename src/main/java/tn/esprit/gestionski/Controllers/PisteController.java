package tn.esprit.gestionski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.Services.IPiste;
import tn.esprit.gestionski.entities.Skieur;

@RestController
@AllArgsConstructor
public class PisteController {
    public IPiste ipiste;

    @PostMapping("/assign/{numSkieur}/{numPiste}")
    public Skieur AssignSkieurToPisteF(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
        return ipiste.AssignSkieurToPiste(numSkieur,numPiste);
    }
}
