package tn.suptech.ihebelhabib;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.suptech.ihebelhabib.domain.*;
import tn.suptech.ihebelhabib.enums.EtatCompte;
import tn.suptech.ihebelhabib.enums.SensTransaction;
import tn.suptech.ihebelhabib.enums.TypeCompte;
import tn.suptech.ihebelhabib.service.*;

import java.util.Date;

@SpringBootApplication
public class IhebElhabibApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhebElhabibApplication.class, args);

    }
    @Bean
    CommandLineRunner start (UserService userService,
                             RoleService roleService,
                             FraisService fraisService,
                             TransactionService transactionService,
                             OperationService operationService,
                             OffreService offreService,
                             CarteService carteService,
                             AdresseService adresseService,
                             ClientService clientService,
                             BanqueService banqueService,
                             AgenceService agenceService,
                             CompteService compteService){
       return  args -> {

           Role role = roleService.add(new Role(null,"Admin","Super Admin"));
           Role role2 = roleService.add(new Role(null,"Client","Client"));

           User user = userService.add(new User(null,"Admin","123"));
           User user2 = userService.add(new User(null,"Client","123"));

           user.setRole(role);
           user2.setRole(role2);

           roleService.update(role);
           roleService.update(role2);

           Banque banque = banqueService.add(new Banque(null,"ZITN", "Zitouna Banque", "ZTN", null, "https://www.banquezitouna.com/", "contact@banquezitouna.com"));
           Offre offre = offreService.add(new Offre(null, "Starter", 72.5, new Date(), banque));
           Adresse adresse = adresseService.add(new Adresse(null,"Tunisie", "Le Bardo", "2000", new Date(), null, null));
           Client client = clientService.add(new Client( null, "elhabib", "iheb", 95198006, "elhabib.iheb@suptech.tn",new Date(), adresse));
           Agence agence = agenceService.add(new Agence( null, 81555555, 31, 18, adresse, banque));
           Compte compte = compteService.add(new Compte(null, EtatCompte.OUVERT, TypeCompte.COURANT, 000001,"ZTN00001", 5000.00,5,0.780, new Date(), agence, client,null, null, null, offre));
           Compte compte2 = compteService.add(new Compte(null,EtatCompte.OUVERT,TypeCompte.COURANT, 000002,"ZTN00002", 2000.00,5,0.780, new Date(), agence, client,null, null, null, offre));
           Carte carte = carteService.add(new Carte(null, "1234 5678 1234 5678",10000,1000, 5, new Date() , compte, null));
           Carte carte2 = carteService.add(new Carte(null, "9999 5678 1234 5678",10000,1000, 5, new Date() , compte2, null));

           compte.setCarte(carte);
           compte2.setCarte(carte2);
           compteService.update(compte);
           compteService.update(compte2);

           Frais frais = fraisService.add(new Frais(null,1430,null));
           Operation operation = operationService.add(new Operation(null,new Date(),compte.getMontant(),230.00,"First extrait",carte));
           Operation operation2 = operationService.add(new Operation(null,new Date(),compte.getMontant(),80.00,"First extrait",carte));
           Operation operation3 = operationService.add(new Operation(null,new Date(),compte.getMontant(),600.00,"First extrait",carte));
           Transaction transaction = transactionService.add(new Transaction(null,750,compte.getRib(),compte2.getRib(),new Date(), SensTransaction.INTERNE,frais));
           Transaction transaction2 = transactionService.add(new Transaction(null,1000,compte2.getRib(),compte.getRib(),new Date(), SensTransaction.INTERNE,frais));
       };
    }


}
