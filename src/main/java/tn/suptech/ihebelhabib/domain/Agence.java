package tn.suptech.ihebelhabib.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity( name = "AGENCE")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEL")
    private int tel;

    @Column(name = "LONGTITUDE")
    private double longtitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @OneToOne()
    @JoinColumn(name = "ADRESSE_ID", referencedColumnName = "id")
    private Adresse adresse;

    @JsonIgnore
    @ManyToOne
    private Banque banque;

    @OneToMany(mappedBy = "agence")
    private List<Compte> comptes;

    public Agence(Long id, int tel, double longtitude, double latitude, Adresse adresse, Banque banque) {
        this.id = id;
        this.tel = tel;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.adresse = adresse;
        this.banque = banque;
    }

    public Agence() {
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
}
