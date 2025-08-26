package sn.edu.ugb.ipsl.ing2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Magasin;
import sn.edu.ugb.ipsl.ing2.entity.Commande;
import sn.edu.ugb.ipsl.ing2.repository.MagasinRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MagasinService {

    @Autowired
    private MagasinRepository magasinRepository;

    // Lister tous les magasins
    public List<Magasin> findAllMagasins() {
        return magasinRepository.findAll();
    }

    // Ajouter un nouveau magasin
    public Magasin addMagasin(Magasin magasin) {
        return magasinRepository.save(magasin);
    }

    // Modifier les informations d'un magasin
    public Magasin updateMagasin(int id, Magasin magasin) {
        magasin.setId(id);
        return magasinRepository.save(magasin);
    }

    // Supprimer un magasin
    public void deleteMagasin(int id) {
        magasinRepository.deleteById(id);
    }

    // Afficher les détails d'un magasin spécifique
    public Optional<Magasin> findMagasinById(int id) {
        return magasinRepository.findById(id);
    }

}
