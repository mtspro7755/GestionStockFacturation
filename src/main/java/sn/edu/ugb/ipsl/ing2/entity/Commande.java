package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int dateCommande;

    @Column(nullable = false)
    private short status;

    @Column(nullable = false)
    private String dateLivraison;

    private String dateLivraisonVoulue;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "magasin_id",nullable = false)
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = "vendeur_id")
    private Employe vendeur;

    public Commande(Long id, int dateCommande, short status, String dateLivraison, String dateLivraisonVoulue, Client client, Magasin magasin, Employe vendeur) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.status = status;
        this.dateLivraison = dateLivraison;
        this.dateLivraisonVoulue = dateLivraisonVoulue;
        this.client = client;
        this.magasin = magasin;
        this.vendeur = vendeur;
    }

    public Commande() {

    }
}
