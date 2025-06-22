package sn.edu.ugb.ipsl.ing2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.ing2.entity.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
