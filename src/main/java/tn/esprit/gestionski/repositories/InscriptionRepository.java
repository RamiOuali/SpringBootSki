package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long>{

    @Query("select e.numSemaine from Inscription e " +
            "join Moniteur m on e.cours MEMBER m.cours where m.id =: numMoniteur and e.cours.support=: support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numMoniteur") long numMoniteur, @Param("support") Support support);
}