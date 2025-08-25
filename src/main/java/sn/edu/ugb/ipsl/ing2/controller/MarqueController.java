package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Categorie;
import sn.edu.ugb.ipsl.ing2.entity.Marque;
import sn.edu.ugb.ipsl.ing2.entity.Produit;
import sn.edu.ugb.ipsl.ing2.service.MarqueService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marques")
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    // Lister toutes les marques
    @GetMapping
    public ResponseEntity<List<Marque>> getMarques() {
        List<Marque> marques = marqueService.getMarqueAll();
        return ResponseEntity.ok(marques);
    }

    // Ajouter une nouvelle marque
    @PostMapping
    public ResponseEntity<String> saveMarque(@RequestBody Marque marque) {
        if (marque.getNom() == null || marque.getDescription() == null) {
            return ResponseEntity.badRequest().body("Le nom et la description de la marque sont requis.");
        }
        marqueService.saveMarque(marque);
        return ResponseEntity.status(HttpStatus.CREATED).body("Marque ajoutée avec succès.");
    }

    // Modifier une marque existante
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMarque(@PathVariable Long id, @RequestBody Marque marque) {
        Optional<Marque> existingMarque = marqueService.getMarque(id);
        if (existingMarque.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marque non trouvée.");
        }
        marque.setId(Math.toIntExact(id));
        marqueService.saveMarque(marque);
        return ResponseEntity.ok("Marque mise à jour avec succès.");
    }

    // Supprimer une marque
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarque(@PathVariable Long id) {
        try {
            Optional<Marque> existingMarque = marqueService.getMarque(id);
            if (existingMarque.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marque non trouvée.");
            }
            marqueService.deleteMarque(id);
            return ResponseEntity.ok("Marque supprimée avec succès.");
        } catch (Exception e) {
            // Log the exception to understand the root cause
            e.printStackTrace(); // Log it in the console or in your logging system
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression de la marque.");
        }
    }

    // Afficher une marque spécifique
    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarque(@PathVariable Long id) {
        return marqueService.getMarque(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Rechercher une marque par nom
    @GetMapping("/search")
    public ResponseEntity<List<Marque>> searchMarquesByNom(@RequestParam String nom) {
        if (nom == null || nom.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Marque> marques = marqueService.findByNom(nom);
        return ResponseEntity.ok(marques);
    }

    // Afficher les produits d'une marque spécifique
    @GetMapping("/{id}/produits")
    public ResponseEntity<List<Produit>> getProduitsByMarqueId(@PathVariable Long id) {
        return marqueService.findProduitsByMarqueId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Afficher les catégories des articles d'une marque spécifique
    @GetMapping("/{id}/categories")
    public ResponseEntity<List<Categorie>> getCategoriesByMarqueId(@PathVariable Long id) {
        return marqueService.findCategoriesByMarqueId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
