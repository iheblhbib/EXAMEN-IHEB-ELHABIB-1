package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "OPERATION")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name ="CREATED")
    private Date created;

    @Column(name = "SOLDE")
    private double solde;

    @Column(name = "DEBIT")
    private double debit;

    @Column(name = "CREDIT")
    private double credit;

    @Column(name = "LIBELLE")
    private String libelle;

    @ManyToOne
    private Carte carte;

    public Operation(Long id, Date created, double solde, double debit, double credit, String libelle) {
        this.id = id;
        this.created = created;
        this.solde = solde;
        this.debit = debit;
        this.credit = credit;
        this.libelle = libelle;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Operation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
