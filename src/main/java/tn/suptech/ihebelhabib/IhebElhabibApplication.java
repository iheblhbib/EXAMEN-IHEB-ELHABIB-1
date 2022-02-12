package tn.suptech.ihebelhabib;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import tn.suptech.ihebelhabib.entities.*;
import tn.suptech.ihebelhabib.enums.EtatCompte;
import tn.suptech.ihebelhabib.repository.AdresseRepository;
import tn.suptech.ihebelhabib.service.*;

import java.util.Date;

@SpringBootApplication
public class IhebElhabibApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhebElhabibApplication.class, args);

    }
    @Bean
    CommandLineRunner start (CarteService carteService, AdresseService adresseService, ClientService clientService, BanqueService banqueService, AgenceService agenceService, CompteService compteService){
       return  args -> {

           Adresse adresse = adresseService.add(new Adresse(null,"Tunisie", "Le Bardo", "2000", new Date(), null, null));
          Client client = clientService.add(new Client( null, "elhaib", "iheb", 95198006, "elhabib.iheb@suptech.tn", adresse, null));
           Banque banque = banqueService.add(new Banque(null,"ZITN", "Zitouna Banque", "ZTN", null, "https://www.banquezitouna.com/", "contact@banquezitouna.com"));
           Agence agence = agenceService.add(new Agence( null, 81555555, 31, 18, adresse, banque, null));
           Compte compte = compteService.add(new Compte(null,null,null, 000001,"ZTN00001", null, new Date(), agence, client, null, null, null));
           Carte carte = carteService.add(new Carte(null, "1234 5678 1234 5678",null,null, 500, new Date() , compte, null));

       };
    }


}
