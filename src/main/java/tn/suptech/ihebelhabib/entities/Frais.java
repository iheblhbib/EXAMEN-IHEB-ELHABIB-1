package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;
import java.util.List;


@Entity( name = "FRAIS")
public class Frais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CION")
    private double cion;

    @OneToMany(mappedBy = "frais")
    private List<Transaction> transactions;

    public Frais(Long id, double cion, List<Transaction> transactions) {
        this.id = id;
        this.cion = cion;
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

    public double getCion() {
        return cion;
    }

    public void setCion(double cion) {
        this.cion = cion;
    }

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transactions = transaction;
    }
}
