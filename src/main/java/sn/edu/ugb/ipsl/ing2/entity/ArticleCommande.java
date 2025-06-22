package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "article_commande")
public class ArticleCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int prixDepart;
    private int quantite;
    private int remiseDecimal;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;
}
