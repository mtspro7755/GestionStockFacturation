package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.ArticleCommande;
import sn.edu.ugb.ipsl.ing2.service.ArticleCommandeService;

import java.util.Optional;

@RestController
@RequestMapping("/api/article-commandes")
@CrossOrigin(origins = "http://localhost:4200")  // autorise Angular
public class ArticleCommandeController {

    @Autowired
    private ArticleCommandeService articleCommandeService;

    @GetMapping()
    public Iterable<ArticleCommande> getArticleCommandes(){
        return articleCommandeService.getArticleCommandeAll();
    }

    @GetMapping("/article-commande/{id}")
    public Optional<ArticleCommande> getArticleCommande(@PathVariable Long id){
        try {
            return articleCommandeService.getArticleCommande(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ArticleCommande> saveArticleCommande(@RequestBody ArticleCommande articleCommande){
        ArticleCommande savedArticleCommandearticleCommande=articleCommandeService.saveArticleCommande(articleCommande);
        return ResponseEntity.ok().body(savedArticleCommandearticleCommande);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ArticleCommande> updateArticleCommande(@PathVariable int id,@RequestBody ArticleCommande articleCommande){
        ArticleCommande updatedArticleCommande=articleCommandeService.updatedArticleCommande(id,articleCommande);
        return ResponseEntity.ok().body(updatedArticleCommande);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticleCommande(@PathVariable Long id){
        articleCommandeService.deleteArticleCommande(id);
        return ResponseEntity.noContent().build();
    }


}
