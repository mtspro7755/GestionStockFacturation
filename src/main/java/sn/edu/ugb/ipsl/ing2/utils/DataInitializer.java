package sn.edu.ugb.ipsl.ing2.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.ing2.entity.*;
import sn.edu.ugb.ipsl.ing2.repository.*;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MagasinRepository magasinRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialiser les données pour Marque
        if (marqueRepository.count() == 0) {
            marqueRepository.saveAll(Arrays.asList(
                    new Marque(null, "Marque A", "Description de la marque A"),
                    new Marque(null, "Marque B", "Description de la marque B"),
                    new Marque(null, "Marque C", "Description de la marque C"),
                    new Marque(null, "Marque D", "Description de la marque D")
            ));
        }

        // Initialiser les données pour Categorie
        if (categorieRepository.count() == 0) {
            categorieRepository.saveAll(Arrays.asList(
                    new Categorie(null, "Catégorie A"),
                    new Categorie(null, "Catégorie B"),
                    new Categorie(null, "Catégorie C"),
                    new Categorie(null, "Catégorie D")
            ));
        }

        // Initialiser les données pour Client
        if (clientRepository.count() == 0) {
            clientRepository.saveAll(Arrays.asList(
                    new Client(null, "Nom A", "Prénom A", "emailA@example.com", "10000", "Actif", "123456789", "Ville A"),
                    new Client(null, "Nom B", "Prénom B", "emailB@example.com", "10001", "Inactif", "123456780", "Ville B"),
                    new Client(null, "Nom C", "Prénom C", "emailC@example.com", "10002", "Actif", "123456781", "Ville C"),
                    new Client(null, "Nom D", "Prénom D", "emailD@example.com", "10003", "Actif", "123456782", "Ville D")
            ));
        }

        // Initialiser les données pour Magasin
        if (magasinRepository.count() == 0) {
            magasinRepository.saveAll(Arrays.asList(
                    new Magasin(0, "Magasin A", "Adresse A", "10000", "Ville A", "Actif", "123456789", "emailA@example.com"),
                    new Magasin(0, "Magasin B", "Adresse B", "10001", "Ville B", "Actif", "123456780", "emailB@example.com"),
                    new Magasin(0, "Magasin C", "Adresse C", "10002", "Ville C", "Inactif", "123456781", "emailC@example.com"),
                    new Magasin(0, "Magasin D", "Adresse D", "10003", "Ville D", "Inactif", "123456782", "emailD@example.com")
            ));
        }

        // Initialiser les données pour Employe
        if (employeRepository.count() == 0) {
            employeRepository.saveAll(Arrays.asList(
                    new Employe(0, "Employé A", "Prénom A", "emailA@example.com", "123456789", magasinRepository.findById(1).orElse(null), null),
                    new Employe(0, "Employé B", "Prénom B", "emailB@example.com", "123456780", magasinRepository.findById(2).orElse(null), null),
                    new Employe(0, "Employé C", "Prénom C", "emailC@example.com", "123456781", magasinRepository.findById(3).orElse(null), null),
                    new Employe(0, "Employé D", "Prénom D", "emailD@example.com", "123456782", magasinRepository.findById(4).orElse(null), null)
            ));
        }

        // Initialiser les données pour Commande
        if (commandeRepository.count() == 0) {
            commandeRepository.saveAll(Arrays.asList(
                    new Commande(0L, "2024-08-02", (short) 1, "2024-08-10", "2024-08-12", clientRepository.findById(1L).orElse(null), magasinRepository.findById(1).orElse(null), employeRepository.findById(1L).orElse(null)),
                    new Commande(0L, "2024-08-02", (short) 2, "2024-08-11", "2024-08-13", clientRepository.findById(2L).orElse(null), magasinRepository.findById(2).orElse(null), employeRepository.findById(2L).orElse(null)),
                    new Commande(0L, "2024-08-02", (short) 1, "2024-08-12", "2024-08-14", clientRepository.findById(3L).orElse(null), magasinRepository.findById(3).orElse(null), employeRepository.findById(3L).orElse(null)),
                    new Commande(0L, "2024-08-02", (short) 2, "2024-08-13", "2024-08-15", clientRepository.findById(4L).orElse(null), magasinRepository.findById(4).orElse(null), employeRepository.findById(4L).orElse(null))
            ));
        }

        // Initialiser les données pour Produit
        if (produitRepository.count() == 0) {
            produitRepository.saveAll(Arrays.asList(
                    new Produit(null, "Produit A", 2024, 1000, categorieRepository.findById(1L).orElse(null), marqueRepository.findById(1L).orElse(null)),
                    new Produit(null, "Produit B", 2024, 2000, categorieRepository.findById(2L).orElse(null), marqueRepository.findById(2L).orElse(null)),
                    new Produit(null, "Produit C", 2024, 3000, categorieRepository.findById(3L).orElse(null), marqueRepository.findById(3L).orElse(null)),
                    new Produit(null, "Produit D", 2024, 4000, categorieRepository.findById(4L).orElse(null), marqueRepository.findById(4L).orElse(null))
            ));
        }

        // Initialiser les données pour Stock
        if (stockRepository.count() == 0) {
            stockRepository.saveAll(Arrays.asList(
                    new Stock(new StockId(1, 1), magasinRepository.findById(1).orElse(null), produitRepository.findById(1L).orElse(null), 10),
                    new Stock(new StockId(1, 2), magasinRepository.findById(1).orElse(null), produitRepository.findById(2L).orElse(null), 20),
                    new Stock(new StockId(2, 3), magasinRepository.findById(2).orElse(null), produitRepository.findById(3L).orElse(null), 30),
                    new Stock(new StockId(2, 4), magasinRepository.findById(2).orElse(null), produitRepository.findById(4L).orElse(null), 40)
            ));
        }
    }
}
