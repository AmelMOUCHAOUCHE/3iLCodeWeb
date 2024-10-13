package fr.troisil.e_commerce.services;

import fr.troisil.e_commerce.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit);
    void delete(Long numProd);
    Produit getById(Long numProd);

    List<Produit> getAll();
    Page<Produit> getAllPaggination(Pageable pageable);

    Page<Produit> findByNomAndDescription(String keyord1, Pageable pageable);
    Page<Produit> findByPrix(float prix, Pageable pageable);
}
