package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String email;

    private String codeZip;
    private String etat;
    private String telephone;
    private String ville;

    public Client() {

    }

    public Client(Integer id, String nom, String prenom, String email, String codeZip, String etat, String telephone, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.codeZip = codeZip;
        this.etat = etat;
        this.telephone = telephone;
        this.ville = ville;
    }
}

