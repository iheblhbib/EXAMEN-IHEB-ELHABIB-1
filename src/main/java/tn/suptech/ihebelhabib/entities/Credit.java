package tn.suptech.ihebelhabib.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.suptech.ihebelhabib.enums.EtatCredit;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT")
    private EtatCredit etat;

    @Column(name = "MONTANT")
    private double montant;

    @Column(name = "AGIOS")
    private double agios;

    @Column(name ="INTERROGATION")
    private Date interrogation;

    @Column(name ="DEPOT")
    private Date depot;

    @JsonIgnore
    @ManyToOne
    private Compte compte;


    public Credit(Long id, EtatCredit etat, double montant, double agios, Date interrogation, Date depot, Compte compte) {
        this.id = id;
        this.etat = etat;
        this.montant = montant;
        this.agios = agios;
        this.interrogation = interrogation;
        this.depot = depot;
        this.compte = compte;
    }

    public Credit() {
    }

    public double getAgios() {
        return agios;
    }

    public void setAgios(double agios) {
        this.agios = agios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EtatCredit getEtat() {
        return etat;
    }

    public void setEtat(EtatCredit etat) {
        this.etat = etat;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getInterrogation() {
        return interrogation;
    }

    public void setInterrogation(Date interrogation) {
        this.interrogation = interrogation;
    }

    public Date getDepot() {
        return depot;
    }

    public void setDepot(Date depot) {
        this.depot = depot;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
