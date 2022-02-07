package tn.suptech.ihebelhabib.entities;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "TEL")
    private int tel;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne()
    @JoinColumn(name = "ADRESSE_ID", referencedColumnName = "id")
    private Adresse adresse;

}
