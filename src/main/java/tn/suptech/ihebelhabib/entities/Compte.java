package tn.suptech.ihebelhabib.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.suptech.ihebelhabib.enums.EtatCompte;
import tn.suptech.ihebelhabib.enums.TypeCompte;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity( name = "COMPTE")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT")
    private EtatCompte etat;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private TypeCompte type;

    @Column(name = "RIB")
    private int rib;

    @Column(name = "IBAN")
    private String iban;

    @Column(name = "MONTANT")
    private double montant;

    @Column(name = "TAUX")
    private double taux;

    @Column(name = "COUT")
    private double cout;

    @Column(name ="CREATED")
    private Date created;

    @JsonIgnore
    @ManyToOne
    private Agence agence;

    @JsonIgnore
    @ManyToOne
    private Client client;



    @OneToOne()
    @JoinColumn(name = "CARTE_ID", referencedColumnName = "id")
    private Carte carte;

    @OneToMany
    private List<Transaction> transaction;

    @OneToMany
    private List<Credit> credits;

    @JsonIgnore
    @ManyToOne
    private Offre offre;

    public Compte(Long id, EtatCompte etat, TypeCompte type, int rib, String iban, double montant, double taux, double cout, Date created, Agence agence, Client client, Carte carte, List<Transaction> transaction, List<Credit> credits, Offre offre) {
        this.id = id;
        this.etat = etat;
        this.type = type;
        this.rib = rib;
        this.iban = iban;
        this.montant = montant;
        this.taux = taux;
        this.cout = cout;
        this.created = created;
        this.agence = agence;
        this.client = client;
        this.carte = carte;
        this.transaction = transaction;
        this.credits = credits;
        this.offre = offre;
    }

    public Compte() {
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public double getTaux() {
        return taux;
    }


    public void setCout(double cout) {
        this.cout = cout;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public double getCout() {
        return cout;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EtatCompte getEtat() {
        return etat;
    }

    public void setEtat(EtatCompte etat) {
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
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
