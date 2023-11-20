package tn.esprit.gestionski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.Services.CoursServiceImp;
import tn.esprit.gestionski.entities.Cours;

import java.util.List;

@RestController
@RequestMapping("/Cour")
public class CoursController {
    @Autowired
    public CoursServiceImp coursServiceImp;

    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours c) {
        return coursServiceImp.addCours(c);
    }

    @PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours c) {
        return coursServiceImp.updateCours(c);
    }

    @GetMapping("/getAll")
    public List<Cours> findAllCours() {
        return coursServiceImp.findAllCours();
    }

    @GetMapping("/get/{numCours}")
    public Cours findById(@PathVariable long numCours) {
        return coursServiceImp.findById(numCours);
    }

    @DeleteMapping("/delete/{numCours}")
    public void deleteCours(@PathVariable long numCours) {
        coursServiceImp.deleteCours(numCours);
    }
}