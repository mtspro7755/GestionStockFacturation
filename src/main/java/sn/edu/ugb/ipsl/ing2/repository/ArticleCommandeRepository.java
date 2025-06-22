package sn.edu.ugb.ipsl.ing2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.ing2.entity.ArticleCommande;

@Repository
public interface ArticleCommandeRepository extends CrudRepository<ArticleCommande, Long> {

}
