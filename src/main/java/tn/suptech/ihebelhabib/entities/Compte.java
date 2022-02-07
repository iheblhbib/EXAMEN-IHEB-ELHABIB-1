package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT")
    private String etat;

    @Column(name = "RIB")
    private int rib;

    @Column(name = "IBAN")
    private String iban;

    @Column(name = "MONTANT")
    private Float montant;

    @Column(name ="CREATED")
    private Date created;

    @ManyToOne
    private Client client;

    @OneToOne()
    @JoinColumn(name = "CARTE_ID", referencedColumnName = "id")
    private Carte carte;

    @OneToMany
    private List<Transaction> transaction;

    public Compte(Long id, String etat, int rib, String iban, Float montant, Date created, Client client, Carte carte, List<Transaction> transaction) {
        this.id = id;
        this.etat = etat;
        this.rib = rib;
        this.iban = iban;
        this.montant = montant;
        this.created = created;
        this.client = client;
        this.carte = carte;
        this.transaction = transaction;
    }

    public Compte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getRib() {
        return rib;
    }

    public void setRib(int rib) {
        this.rib = rib;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
