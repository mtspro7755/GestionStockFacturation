package sn.edu.ugb.ipsl.ing2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Marque;
import sn.edu.ugb.ipsl.ing2.entity.Produit;
import sn.edu.ugb.ipsl.ing2.entity.Categorie;
import sn.edu.ugb.ipsl.ing2.repository.MarqueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    // Lister toutes les marques
    public List<Marque> getMarqueAll() {
        return marqueRepository.findAll();
    }

    // Obtenir une marque par ID
    public Optional<Marque> getMarque(Long id) {
        return marqueRepository.findById(id);
    }

    // Ajouter ou mettre à jour une marque
    public Marque saveMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    // Supprimer une marque par ID
    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }

    // Rechercher une marque par nom
    public List<Marque> findByNom(String nom) {
        return marqueRepository.findByNomContainingIgnoreCase(nom);
    }

    // Afficher les produits d'une marque spécifique
    public Optional<List<Produit>> findProduitsByMarqueId(Long id) {
        // Assurez-vous que vous avez une relation définie pour accéder aux produits de la marque
        return marqueRepository.findById(id)
                .map(Marque::getProduits); // Assume that Marque entity has a getProduits() method
    }

    // Afficher les catégories des articles d'une marque spécifique
    public Optional<List<Categorie>> findCategoriesByMarqueId(Long id) {
        // Assurez-vous que vous avez une relation définie pour accéder aux catégories des articles de la marque
        return marqueRepository.findById(id)
                .map(Marque::getCategories); // Assume that Marque entity has a getCategories() method
    }
}
