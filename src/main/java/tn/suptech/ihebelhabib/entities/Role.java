package tn.suptech.ihebelhabib.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME")
    private String Name;

    @Column(name="DESCRIPTION")
    private String Description;

    @JsonIgnore
    @ManyToMany()
    @JoinTable(name="USER_ROLE", joinColumns = @JoinColumn(name="ROLE_ID"),inverseJoinColumns = @JoinColumn(name="USER_ID"))
    private Set<User> users ;
}
