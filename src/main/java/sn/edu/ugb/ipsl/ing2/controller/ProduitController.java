package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Produit;
import sn.edu.ugb.ipsl.ing2.service.ProduitService;

import java.util.Optional;

@RestController
@RequestMapping("/produits")
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
    public Produit saveProduit(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    @PutMapping("/update")
    public Produit updateProduit(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
    }
}
