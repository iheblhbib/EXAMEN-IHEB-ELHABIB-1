package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;
import java.util.List;


@Entity( name = "FRAIS")
public class Frais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AGIOS")
    private double AGIOS;

    @OneToMany(mappedBy = "frais")
    private List<Transaction> transactions;

    public Frais(Long id, double AGIOS, List<Transaction> transactions) {
        this.id = id;
        this.AGIOS = AGIOS;
        this.transactions = transactions;
    }

    public Frais() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAGIOS() {
        return AGIOS;
    }

    public void setAGIOS(double AGIOS) {
        this.AGIOS = AGIOS;
    }

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transactions = transaction;
    }
}
