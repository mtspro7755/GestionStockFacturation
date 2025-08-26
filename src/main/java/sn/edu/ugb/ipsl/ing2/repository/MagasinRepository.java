package sn.edu.ugb.ipsl.ing2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.ing2.entity.Magasin;
import sn.edu.ugb.ipsl.ing2.entity.Commande;

import java.util.List;

public interface MagasinRepository extends JpaRepository<Magasin, Integer> {

}
