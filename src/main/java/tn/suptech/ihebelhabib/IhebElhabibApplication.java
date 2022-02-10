package tn.suptech.ihebelhabib;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import tn.suptech.ihebelhabib.entities.Adresse;
import tn.suptech.ihebelhabib.entities.Agence;
import tn.suptech.ihebelhabib.entities.Client;
import tn.suptech.ihebelhabib.repository.AdresseRepository;
import tn.suptech.ihebelhabib.service.AdresseService;

import java.util.Date;

@SpringBootApplication
public class IhebElhabibApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhebElhabibApplication.class, args);

    }
    @Bean
    CommandLineRunner start (AdresseService adresseService){
       return  args -> {
           adresseService.add(new Adresse(null,"tunisie", "", "", new Date(), null, null));

       };
    }

}
