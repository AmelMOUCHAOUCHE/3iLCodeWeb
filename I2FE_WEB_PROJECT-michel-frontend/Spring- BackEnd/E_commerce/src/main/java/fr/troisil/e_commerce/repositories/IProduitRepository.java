package fr.troisil.e_commerce.repositories;

import fr.troisil.e_commerce.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitRepository extends JpaRepository<Produit, Long>
{
    Page<Produit> findByNomContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keyord1, String keyord2, Pageable pageable);

    Page<Produit> findByPrixGreaterThanEqual(float prix, Pageable pageable);
}