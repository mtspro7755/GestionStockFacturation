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
    public ResponseEntity<Marque> saveMarque(@RequestBody Marque marque) {
        Marque marquesaved= marqueService.saveMarque(marque);
        return ResponseEntity.status(HttpStatus.CREATED).body(marquesaved);
    }

    // Modifier une marque existante
    @PutMapping("/{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable int id, @RequestBody Marque marque) {
        Marque update= marqueService.updateMarque(id,marque);
        return ResponseEntity.ok(update);
    }

    // Supprimer une marque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        marqueService.deleteMarque(id);
        return ResponseEntity.noContent().build();
    }

    // Afficher une marque spécifique
    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarque(@PathVariable Long id) {
        Optional<Marque> marque =marqueService.getMarque(id);
        return marque.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

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


}
