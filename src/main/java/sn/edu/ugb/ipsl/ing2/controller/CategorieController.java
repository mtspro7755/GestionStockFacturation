package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Categorie;
import sn.edu.ugb.ipsl.ing2.service.CategorieService;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {


    @Autowired
    private CategorieService categorieService;

    @GetMapping()
    public Iterable<Categorie> getCategories(){
        return categorieService.getCategorieAll();
    }

    @GetMapping("/categorie/{id}")
    public Optional<Categorie> getCategorie(@PathVariable Long id){
        try {
            return categorieService.getCategorie(id);
        }catch (Exception e){
            return Optional.empty();
        }

    }

    @PostMapping("/create")
    public Categorie saveCategorie(@RequestBody Categorie categorie){
        return categorieService.saveCategorie(categorie);
    }

    @PutMapping("/update")
    public Categorie updateCategorie(@RequestBody Categorie categorie){
        return categorieService.saveCategorie(categorie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAbsent(@PathVariable Long id){
        categorieService.deleteCategorie(id);
    }

}
