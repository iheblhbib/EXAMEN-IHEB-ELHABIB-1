package tn.suptech.ihebelhabib.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "REFERENCE")
    private String reference;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "SLOGON")
    private String slogon;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "SITEWEB")
    private String siteweb;

    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "banque")
    private List<Agence> agences;

    @OneToMany(mappedBy = "banque")
    private List<Offre> offres;




    public Banque(Long id, String referance, String nom, String slogon, String logo, String siteweb, String email) {
        this.id = id;
        this.reference = referance;
        this.nom = nom;
        this.slogon = slogon;
        this.logo = logo;
        this.siteweb = siteweb;
        this.email = email;
    }

    public Banque() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferance() {
        return reference;
    }

    public void setReferance(String referance) {
        this.reference = referance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSlogon() {
        return slogon;
    }

    public void setSlogon(String slogon) {
        this.slogon = slogon;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
