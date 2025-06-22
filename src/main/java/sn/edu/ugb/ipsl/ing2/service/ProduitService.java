package sn.edu.ugb.ipsl.ing2.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Produit;
import sn.edu.ugb.ipsl.ing2.repository.ProduitRepository;

import java.util.Optional;

@Service
@Data
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Optional<Produit> getProduit(final Long id) {
        return produitRepository.findById(id);
    }

    public Iterable<Produit> getProduitAll() {
        return produitRepository.findAll();
    }

    public void deleteProduit(final Long id) {
        produitRepository.deleteById(id);
    }

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}
