package sn.edu.ugb.ipsl.ing2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.ing2.entity.Marque;
import java.util.List;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
    List<Marque> findByNomContainingIgnoreCase(String nom);
}
