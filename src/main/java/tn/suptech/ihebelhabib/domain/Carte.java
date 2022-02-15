package tn.suptech.ihebelhabib.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity( name = "CARTE")
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUM")
    private String num;

    @Column(name = "PLAFOND_GLOBAL")
    private double plafondGlobal;

    @Column(name = "PLAFOND_RETRAIT")
    private double plafondRetrait;

    @Column(name = "COTISATION")
    private double cotisation;

    @Column(name ="CREATED")
    private Date created;

    @JsonIgnore
    @OneToOne(mappedBy = "carte")
    private Compte compte ;

    @OneToMany(mappedBy = "carte")
    private List<Operation> operation;

    public Carte(Long id, String num, double plafondGlobal, double plafondRetrait, double cotisation, Date created, Compte compte, List<Operation> operation) {
        this.id = id;
        this.num = num;
        this.plafondGlobal = plafondGlobal;
        this.plafondRetrait = plafondRetrait;
        this.cotisation = cotisation;
        this.created = created;
        this.compte = compte;
        this.operation = operation;
    }

    public Carte() {
    }

    public List<Operation> getOperation() {
        return operation;
    }

    public void setOperation(List<Operation> operation) {
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getPlafondGlobal() {
        return plafondGlobal;
    }

    public void setPlafondGlobal(double plafondGlobal) {
        this.plafondGlobal = plafondGlobal;
    }

    public double getPlafondRetrait() {
        return plafondRetrait;
    }

    public void setPlafondRetrait(double plafondRetrait) {
        this.plafondRetrait = plafondRetrait;
    }

    public double getCotisation() {
        return cotisation;
    }

    public void setCotisation(double cotisation) {
        this.cotisation = cotisation;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
