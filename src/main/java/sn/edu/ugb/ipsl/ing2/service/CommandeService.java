package sn.edu.ugb.ipsl.ing2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Commande;
import sn.edu.ugb.ipsl.ing2.repository.CommandeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Trouver toutes les commandes
    public List<Commande> findAllCommandes() {
        return commandeRepository.findAll();
    }

    // Ajouter une nouvelle commande
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Mettre à jour une commande existante
    public Commande updateCommande(Long id, Commande commande) {
        if (commandeRepository.existsById(id)) {
            commande.setId(id);
            return commandeRepository.save(commande);
        }
        return null; // Ou lancer une exception personnalisée
    }

    // Supprimer une commande
    public void deleteCommande(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
        }
    }

    // Trouver une commande par son ID
    public Optional<Commande> findCommandeById(Long id) {
        return commandeRepository.findById(id);
    }
}
