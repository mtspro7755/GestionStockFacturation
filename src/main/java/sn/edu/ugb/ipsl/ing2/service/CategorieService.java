package sn.edu.ugb.ipsl.ing2.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Categorie;
import sn.edu.ugb.ipsl.ing2.repository.CategorieRepository;

import java.util.Optional;

@Service
@Data
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Optional<Categorie> getCategorie(final Long id){
        return categorieRepository.findById(id);
    }

    public Iterable<Categorie> getCategorieAll(){
        return categorieRepository.findAll();
    }

    public void deleteCategorie(final Long id){
        categorieRepository.deleteById(id);
    }

    public Categorie saveCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(int id, Categorie categorie){
        categorie.setId(id);
        return categorieRepository.save(categorie);
    }



}
