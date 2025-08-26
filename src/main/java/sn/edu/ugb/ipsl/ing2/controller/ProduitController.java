package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Produit;
import sn.edu.ugb.ipsl.ing2.service.ProduitService;

import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping()
    public Iterable<Produit> getProduits(){
        return produitService.getProduitAll();
    }

    @GetMapping("/produit/{id}")
    public Optional<Produit> getProduit(@PathVariable Long id){
        try {
            return produitService.getProduit(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Produit> saveProduit(@RequestBody Produit produit){
        Produit savedProduit=produitService.saveProduit(produit);
        return ResponseEntity.ok().body(savedProduit);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable int id, @RequestBody Produit produit){
        Produit updatedProduit=produitService.updateProduit(id,produit);
        return ResponseEntity.ok(updatedProduit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
    }
}
