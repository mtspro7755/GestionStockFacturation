package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marque")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    private String description;

    public List<Produit> getProduits() {
        return List.of();
    }

    public List<Categorie> getCategories() {
        return List.of();
    }

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "marque")
    //private List<Produit> produits;

}
