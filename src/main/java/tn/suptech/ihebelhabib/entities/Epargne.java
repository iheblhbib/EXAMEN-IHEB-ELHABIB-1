package tn.suptech.ihebelhabib.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("epargne")
public class Epargne extends Compte {

    public Epargne(Long id, String etat, int rib, String iban, Float montant, Date created, Client client, Carte carte, List<Transaction> transaction) {
        super(id, etat, rib, iban, montant, created, client, carte, transaction);
    }

    public Epargne() {
    }


}
