package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "stock")
public class Stock {

    @EmbeddedId
    private StockId id;

    @ManyToOne
    @MapsId("magasinId")
    @JoinColumn(name = "magasin_id")
    private Magasin magasin;

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @Column(nullable = false)
    private int quantite;

    public Stock(StockId id, Magasin magasin, Produit produit, int quantite) {
        this.id = id;
        this.magasin = magasin;
        this.produit = produit;
        this.quantite = quantite;
    }


    public Stock() {

    }
}
