package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int anneeModel;

    @Column(nullable = false)
    private int prixDepart;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;



    public Produit(Integer id, String nom, Integer anneeModel, Integer prixDepart, Categorie categorie, Marque marque) {
        this.id = id;
        this.nom = nom;
        this.anneeModel = anneeModel;
        this.prixDepart = prixDepart;
        this.categorie = categorie;
        this.marque = marque;
    }

    public Produit() {
    }
}
