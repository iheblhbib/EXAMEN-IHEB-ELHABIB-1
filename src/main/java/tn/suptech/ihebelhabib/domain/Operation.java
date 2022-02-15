package tn.suptech.ihebelhabib.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    // Old montant du compte
    @Column(name = "OLDMONTANT")
    private double oldmontant;

    // Combien le montant de operation
    @Column(name = "MONTANT")
    private double montant;

    // total montant apres l'operation
    @Column(name = "NEWMONTANT")
    private double newmontant;

    @Column(name = "LIBELLE")
    private String libelle;

    @JsonIgnore
    @ManyToOne
    private Carte carte;

    public Operation(Long id, Date created, double oldmontant, double montant,  String libelle, Carte carte) {
        this.id = id;
        this.created = created;
        this.oldmontant = oldmontant;
        this.montant = montant;
        this.libelle = libelle;
        this.carte = carte;
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

    public double getOldmontant() {
        return oldmontant;
    }

    public void setOldmontant(double oldmontant) {
        this.oldmontant = oldmontant;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getNewmontant() {
        return newmontant;
    }

    public void setNewmontant(double newmontant) {
        this.newmontant = newmontant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
