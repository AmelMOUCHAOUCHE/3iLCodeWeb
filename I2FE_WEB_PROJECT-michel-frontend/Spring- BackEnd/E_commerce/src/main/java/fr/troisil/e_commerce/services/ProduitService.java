package fr.troisil.e_commerce.services;


import fr.troisil.e_commerce.entity.Produit;
import fr.troisil.e_commerce.repositories.IProduitRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProduitService implements IProduitService {


    private IProduitRepository produitRepository;

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void delete(Long numProd) {
        produitRepository.deleteById(numProd);
    }

    @Override
    public Produit getById(Long numProd) {
        return produitRepository.findById(numProd).orElse(null);
    }

    @Override
    public List<Produit> getAll() {
        return  produitRepository.findAll();
    }

    @Override
    public Page<Produit> getAllPaggination(Pageable pageable) {
        return  produitRepository.findAll(pageable);
    }

    @Override
    public Page<Produit> findByNomAndDescription(String keyord1, Pageable pageable) {
        return produitRepository.findByNomContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyord1, keyord1, pageable);
    }

    @Override
    public Page<Produit> findByPrix(float prix, Pageable pageable) {
        return this.produitRepository.findByPrixGreaterThanEqual(prix, pageable);
    }

}
