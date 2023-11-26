package tn.esprit.gestionski.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class AbonnmentServiceImp  implements  IAbonnement{
AbonnementRepository repository ;
    SkieurRepository skieurRepository ;
    @Override
    public List<Abonnement> getAbonnementTypeAndDate(TypeAbonnement T) {
        return repository.getAbonnementByTypeAbonOrderByDateDebut(T);
    }


    @Override
    public List<Abonnement> findAbonnementBetweenDateDebutDateFin(Date dateDebut, Date dateFin) {
        return repository.findAbonnementByDateDebutBetween(dateDebut,dateFin);
    }


    @Scheduled(fixedRate = 5000)
    public void showMonthlyRecurringRevenue() {
        List<Skieur> skieurList = skieurRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        double MRR = 0.0;

        for (Skieur skieur : skieurList) {
            Abonnement abonnement = skieur.getAbonnement();

            if (abonnement.getDateFin().isAfter(currentDate)) {
                MRR += abonnement.getPrixAbon();
            }
        }

        System.out.println("MMR: " + MRR);
    }


}



