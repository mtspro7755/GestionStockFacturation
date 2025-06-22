package sn.ugb.ipsl.gestionstockfacturation.entity;

import jakarta.persistence.Entity;

public class Marque {
}
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
}
