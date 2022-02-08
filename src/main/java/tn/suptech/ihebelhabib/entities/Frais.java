package tn.suptech.ihebelhabib.entities;
import javax.persistence.*;


@Entity
public class Frais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AGIOS")
    private double AGIOS;

    @OneToOne()
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "id")
    private Transaction transaction;
}
