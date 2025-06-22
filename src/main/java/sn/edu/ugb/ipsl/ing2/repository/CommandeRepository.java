package sn.edu.ugb.ipsl.ing2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.ing2.entity.Commande;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    // Trouver les commandes par ID de magasin
    List<Commande> findByMagasinId(int magasinId);
}
