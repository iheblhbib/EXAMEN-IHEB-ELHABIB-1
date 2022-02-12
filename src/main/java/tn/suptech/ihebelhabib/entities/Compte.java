package tn.suptech.ihebelhabib.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.suptech.ihebelhabib.enums.EtatCompte;
import tn.suptech.ihebelhabib.enums.TypeCompte;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity( name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    private Float montant;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "comptes" )
    private Set<Offre> offres;

    public Compte(Long id, EtatCompte etat, TypeCompte type, int rib, String iban, Float montant, Date created, Agence agence, Client client, Carte carte, List<Transaction> transaction, Set<Offre> offres) {
        this.id = id;
        this.etat = etat;
        this.type = type;
        this.rib = rib;
        this.iban = iban;
        this.montant = montant;
        this.created = created;
        this.agence = agence;
        this.client = client;
        this.carte = carte;
        this.transaction = transaction;
        this.offres = offres;
    }

    public Compte() {
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

    public Set<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Set<Offre> offres) {
        this.offres = offres;
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
