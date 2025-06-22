package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
   // private List<Produit> produits;

    // Constructeur avec arguments
    public Categorie(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Categorie() {

    }
}
