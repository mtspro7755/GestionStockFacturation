package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.ArticleCommande;
import sn.edu.ugb.ipsl.ing2.service.ArticleCommandeService;

import java.util.Optional;

@RestController
@RequestMapping("/article-commandes")
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
    public ArticleCommande saveArticleCommande(@RequestBody ArticleCommande articleCommande){
        return articleCommandeService.saveArticleCommande(articleCommande);
    }

    @PutMapping("/update")
    public ArticleCommande updateArticleCommande(@RequestBody ArticleCommande articleCommande){
        return articleCommandeService.saveArticleCommande(articleCommande);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticleCommande(@PathVariable Long id){
        articleCommandeService.deleteArticleCommande(id);
    }
}
