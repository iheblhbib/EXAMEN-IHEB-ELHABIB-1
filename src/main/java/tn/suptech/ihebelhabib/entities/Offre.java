package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity( name = "OFFRE")
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LIBELLE")
    private String libelle;

    @Column(name = "frais")
    private double frais;

    @Column(name ="CREATED")
    private Date created;

    @ManyToOne
    private Banque banque;

    @ManyToMany()
    @JoinTable(name="COMPTE_OFFRE", joinColumns = @JoinColumn(name="OFFRE_ID"),inverseJoinColumns = @JoinColumn(name="COMPTE_ID"))
    private Set<Compte> comptes ;

    public Offre(Long id, String libelle, double frais, Date created, Banque banque) {
        this.id = id;
        this.libelle = libelle;
        this.frais = frais;
        this.created = created;
        this.banque = banque;
    }

    public Offre() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
}
