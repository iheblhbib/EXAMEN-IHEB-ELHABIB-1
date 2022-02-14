package tn.suptech.ihebelhabib.entities;

import tn.suptech.ihebelhabib.enums.SensTransaction;

import javax.persistence.*;
import java.util.Date;

@Entity( name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MONTANT")
    private double montant;

    @Column(name = "DISTINATAIRE")
    private int distinataire;

    @Column(name = "SOURCE")
    private int source;

    @Column(name ="CREATED")
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "SENS")
    private SensTransaction sens;

    @ManyToOne
    private Frais frais;

    @ManyToOne
    private Compte compte;

    public Transaction() {
    }

    public Transaction(Long id, double montant, int distinataire, int source, Date created, SensTransaction sens, Frais frais, Compte compte) {
        this.id = id;
        this.montant = montant;
        this.distinataire = distinataire;
        this.source = source;
        this.created = created;
        this.sens = sens;
        this.frais = frais;
        this.compte = compte;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Frais getFrais() {
        return frais;
    }

    public void setFrais(Frais frais) {
        this.frais = frais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getDistinataire() {
        return distinataire;
    }

    public void setDistinataire(int distinataire) {
        this.distinataire = distinataire;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public SensTransaction getSens() {
        return sens;
    }

    public void setSens(SensTransaction sens) {
        this.sens = sens;
    }
}
