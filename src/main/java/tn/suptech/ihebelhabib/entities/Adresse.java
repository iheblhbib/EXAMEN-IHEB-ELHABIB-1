package tn.suptech.ihebelhabib.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adresse {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PAYS")
    private String pays;

    @Column(name = "VILLE")
    private String ville;

    @Column(name ="ZIPCODE")
    private String zipCode;


    @OneToOne(mappedBy = "adresse_client")
    private Client client ;

    @OneToOne(mappedBy = "adresse_agence")
    private Agence agence ;


    public Adresse(Long id, String pays, String ville, String zipCode) {
        this.id = id;
        this.pays = pays;
        this.ville = ville;
        this.zipCode = zipCode;
    }

    public Adresse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
