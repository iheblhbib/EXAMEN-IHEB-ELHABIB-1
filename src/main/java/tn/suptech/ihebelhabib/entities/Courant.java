package tn.suptech.ihebelhabib.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity( name = "COURANT")
@DiscriminatorValue("courant")
public class Courant extends Compte {

    public Courant(Long id, String etat, int rib, String iban, Float montant, Date created, Client client, Carte carte, List<Transaction> transaction) {
        super(id, etat, rib, iban, montant, created, client, carte, transaction);
    }

    public Courant() {
    }
}
