package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Magasin;
import sn.edu.ugb.ipsl.ing2.entity.Commande;
import sn.edu.ugb.ipsl.ing2.service.MagasinService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/magasins")
public class MagasinController {

    @Autowired
    private MagasinService magasinService;

    // Lister tous les magasins
    @GetMapping
    public ResponseEntity<List<Magasin>> getAllMagasins() {
        List<Magasin> magasins = magasinService.findAllMagasins();
        return ResponseEntity.ok(magasins);
    }

    // Ajouter un nouveau magasin
    @PostMapping
    public ResponseEntity<Magasin> addMagasin(@RequestBody Magasin magasin) {
        Magasin newMagasin = magasinService.addMagasin(magasin);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMagasin);
    }

    // Modifier les informations d'un magasin
    @PutMapping("/{id}")
    public ResponseEntity<Magasin> updateMagasin(@PathVariable int id, @RequestBody Magasin magasin) {
        Magasin updatedMagasin = magasinService.updateMagasin(id, magasin);
        return ResponseEntity.ok(updatedMagasin);
    }

    // Supprimer un magasin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMagasin(@PathVariable int id) {
        magasinService.deleteMagasin(id);
        return ResponseEntity.noContent().build();
    }

    // Afficher les détails d'un magasin spécifique
    @GetMapping("/{id}")
    public ResponseEntity<Magasin> getMagasinById(@PathVariable int id) {
        Optional<Magasin> magasin = magasinService.findMagasinById(id);
        return magasin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lister les commandes d'un magasin spécifique
    @GetMapping("/get-allcommandes-by-id-magasin/{id}")
    public ResponseEntity<List<Commande>> getCommandesByMagasinId(@PathVariable int id) {
        List<Commande> commandes = magasinService.findCommandesByMagasinId(id);
        return ResponseEntity.ok(commandes);
    }
}
