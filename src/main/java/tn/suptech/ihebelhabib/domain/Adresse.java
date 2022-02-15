package tn.suptech.ihebelhabib.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity( name = "ADRESSE")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PAYS")
    private String pays;

    @Column(name = "VILLE")
    private String ville;

    @Column(name ="ZIPCODE")
    private String zipCode;

    @Column(name ="CREATED")
    private Date created;

    @JsonIgnore
    @OneToOne(mappedBy = "adresse")
    private Client client ;

    @JsonIgnore
    @OneToOne(mappedBy = "adresse")
    private Agence agence ;

    public Adresse(Long id, String pays, String ville, String zipCode, Date created, Client client, Agence agence) {
        this.id = id;
        this.pays = pays;
        this.ville = ville;
        this.zipCode = zipCode;
        this.created = created;
        this.client = client;
        this.agence = agence;
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
