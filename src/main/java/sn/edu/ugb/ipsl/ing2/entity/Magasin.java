package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "magasin")
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    private String adresse;
    private String codeZip;
    private String ville;
    private String etat;
    private String telephone;
    private String email;

    //@OneToMany(mappedBy = "magasin")
    //private List<Stock> stocks;

    //@OneToMany(mappedBy = "magasin")
    //private List<Employe> employes;

    public Magasin(Integer id, String nom, String adresse, String codeZip, String ville, String etat, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.codeZip = codeZip;
        this.ville = ville;
        this.etat = etat;
        this.telephone = telephone;
        this.email = email;
    }

    public Magasin() {

    }
}
