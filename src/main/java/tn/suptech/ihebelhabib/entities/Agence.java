package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;


@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "TEL")
    private int tel;

    @Column(name = "LONGTITUDE")
    private String longtitude;

    @Column(name = "LATITUDE")
    private String latitude;

    @ManyToOne
    private Banque banque;

    public Agence(Long id, String adresse, int tel, String longtitude, String latitude, Banque banque) {
        this.id = id;
        this.adresse = adresse;
        this.tel = tel;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.banque = banque;
    }

    public Agence() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
}