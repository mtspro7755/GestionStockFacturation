package sn.edu.ugb.ipsl.ing2.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.ArticleCommande;
import sn.edu.ugb.ipsl.ing2.repository.ArticleCommandeRepository;

import java.util.Optional;

@Service
@Data
public class ArticleCommandeService {

    @Autowired
    private ArticleCommandeRepository articleCommandeRepository;

    public Optional<ArticleCommande> getArticleCommande(final Long id) {
        return articleCommandeRepository.findById(id);
    }

    public Iterable<ArticleCommande> getArticleCommandeAll() {
        return articleCommandeRepository.findAll();
    }

    public void deleteArticleCommande(final Long id) {
        articleCommandeRepository.deleteById(id);
    }

    public ArticleCommande saveArticleCommande(ArticleCommande articleCommande) {
        return articleCommandeRepository.save(articleCommande);
    }

    public ArticleCommande updatedArticleCommande(int id,ArticleCommande articleCommande) {
        articleCommande.setId(id);
        return articleCommandeRepository.save(articleCommande);
    }


}
